/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.repository.impl;

import com.tonynhu.pojos.Schedule;
import com.tonynhu.repository.DoctorRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class DoctorRepositoryImpl implements DoctorRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Autowired
    private Environment env;

    @Override
    public List<Schedule> getSchedules(String kw, int page) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Schedule> q = b.createQuery(Schedule.class);
        Root root = q.from(Schedule.class);
        q.select(root);

        if (kw != null && !kw.isEmpty()) {
            Predicate p = b.like(root.get("client_fullname").as(String.class), String.format("%%%s%%", kw));
            q.where(p);
        }
        q.orderBy(b.desc(root.get("id")));
        Query query = session.createQuery(q);

        int pageSize = Integer.parseInt(env.getProperty("info.page_size"));
        int start = (page - 1) * pageSize;

        query.setMaxResults(pageSize);
        query.setFirstResult(start);
        return query.getResultList();
    }

}
