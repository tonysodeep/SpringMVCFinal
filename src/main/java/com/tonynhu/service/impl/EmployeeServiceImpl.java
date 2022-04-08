/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tonynhu.pojos.Employee;
import com.tonynhu.repository.EmployeeRepository;
import com.tonynhu.service.EmployeeService;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author hyngu
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addEmployee(Employee employee) {
        if (employee.getFile() != null) {
            try {
                Map res = this.cloudinary.uploader().upload(employee.getFile().
                        getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                employee.setImage((String) res.get("secure_url"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        employee.setPassword(this.passwordEncoder.encode(employee.getPassword()));
        
        return this.employeeRepository.addEmployee(employee);
    }

}
