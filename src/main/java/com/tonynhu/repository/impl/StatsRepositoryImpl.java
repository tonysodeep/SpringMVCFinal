/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.repository.impl;

import com.tonynhu.pojos.Category;
import com.tonynhu.pojos.Medicine;
import com.tonynhu.pojos.Prescription;
import com.tonynhu.pojos.PrescriptionDetail;
import com.tonynhu.repository.StatsRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hyngu
 */
@Repository
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public List<Object[]> couteCates() {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootM = q.from(Medicine.class);
        Root rootC = q.from(Category.class);

        q.where(b.equal(rootM.get("category"), rootC.get("id")));
        q.multiselect(rootC.get("id"), rootC.get("name"), b.count(rootM.get("id")));
        q.groupBy(rootC.get("id"));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> medicineRevenue(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootM = q.from(Medicine.class);
        Root rootP = q.from(Prescription.class);
        Root rootD = q.from(PrescriptionDetail.class);

        List<Predicate> pre = new ArrayList<>();
        pre.add(b.equal(rootD.get("medicineId"), rootM.get("id")));
        pre.add(b.equal(rootD.get("prescriptionId"), rootP.get("id")));

        if (kw != null && !kw.isEmpty()) {
            pre.add(b.like(rootM.get("name"), String.format("%%%s%%", kw)));
        }

        if (fromDate != null) {
            pre.add(b.greaterThanOrEqualTo(rootP.get("createDate"), fromDate));
        }

        if (toDate != null) {
            pre.add(b.lessThanOrEqualTo(rootP.get("createDate"), toDate));
        }

        q.multiselect(rootM.get("id"), rootM.get("name"),
                b.sum(b.prod(rootD.get("price"), rootD.get("quantity"))));

        q.where(pre.toArray(new Predicate[]{}));

        q.groupBy(rootM.get("id"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

}
