/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.repository.impl;

import com.tonynhu.pojos.Employee;
import com.tonynhu.pojos.Medicine;
import com.tonynhu.repository.MedicineRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.predicate.BetweenPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hyngu
 */
@Repository
@Transactional
@PropertySource("classpath:info.properties")
public class MedicineRepositoryImpl implements MedicineRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Autowired
    private Environment env;

    @Override
    public List<Medicine> getMedicines(Map<String, String> params, int page) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Medicine> q = b.createQuery(Medicine.class);
        Root root = q.from(Medicine.class);
        q.select(root);

        String kw = params.get("kw");
        List<Predicate> predicates = new ArrayList<>();
        if (kw != null && !kw.isEmpty()) {
            Predicate p = b.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            predicates.add(p);
        }

        String cateId = params.get("categoryId");

        if (cateId != null && !cateId.isEmpty()) {
            Predicate p2 = b.equal(root.get("category"), Integer.parseInt(cateId));
            predicates.add(p2);
        }

        if (predicates.size() > 0) {
            q.where(predicates.toArray(new Predicate[]{}));
        }

        q.orderBy(b.desc(root.get("id")));
        Query query = session.createQuery(q);

        int pageSize = Integer.parseInt(env.getProperty("info.page_size"));
        int start = (page - 1) * pageSize;

        query.setMaxResults(pageSize);
        query.setFirstResult(start);
        return query.getResultList();
    }

    @Override
    public int countMedicines() {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Medicine");
        Object re = q.getSingleResult();
        return Integer.parseInt(re.toString());
    }

    @Override
    public boolean addOrUpdateProduct(Medicine m) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        System.out.println("medi id ------------"+m.getId());
        try {
            if (m.getId() == null) {
                session.save(m);
            } else {
                Medicine updateMedicine = this.getMedicineById(m.getId());
                updateMedicine.setImage(m.getName());
                updateMedicine.setDescription(m.getDescription());
                updateMedicine.setPrice(m.getPrice());
                session.save(updateMedicine);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Medicine getMedicineById(int id) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        return s.get(Medicine.class, id);
    }

    @Override
    public void deleteMedicine(Medicine medicine) {
         Session s = this.sessionFactoryBean.getObject().getCurrentSession();
         s.delete(medicine);
         return;
    }

}
