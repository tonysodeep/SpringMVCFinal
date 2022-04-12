/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.repository.impl;

import com.tonynhu.pojos.Employee;
import com.tonynhu.repository.EmployeeRepository;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hyngu
 */
@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public boolean addEmployee(Employee employee) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            if (employee.getId() == null) {
                s.save(employee);
            } else {
                Employee updateEmployee = getEmployeeById(employee.getId());
                updateEmployee.setFullname(employee.getFullname());
                updateEmployee.setMobile(employee.getMobile());
                updateEmployee.setAddress(employee.getAddress());
                s.save(updateEmployee);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Employee> q = b.createQuery(Employee.class);
        Root root = q.from(Employee.class);
        q.select(root);

        q.where(b.equal(root.get("email"), email));

        Query query = session.createQuery(q);
        return (Employee) query.getSingleResult();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        return s.get(Employee.class, id);
    }

}
