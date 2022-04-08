/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.repository.impl;

import com.tonynhu.pojos.Employee;
import com.tonynhu.repository.EmployeeRepository;
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
public class EmployeeRepositoryImpl implements EmployeeRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    
    @Override
    public boolean addEmployee(Employee employee) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            s.save(employee);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
