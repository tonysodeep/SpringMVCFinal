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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author hyngu
 */
@Service("userDetailsService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addEmployee(Employee employee) {
        System.out.println("check add emple" + employee.getId());
        if (employee.getId() != null) {
            return this.employeeRepository.addEmployee(employee);
        } else {
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = this.employeeRepository.getEmployeeByEmail(email);
        if (email == null) {
            throw new UsernameNotFoundException("Invail Email");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(employee.getRole()));
        return new User(employee.getEmail(), employee.getPassword(), authorities);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return this.employeeRepository.getEmployeeByEmail(email);
    }

    @Override
    public Employee getEmployeeById(int i) {
        return this.employeeRepository.getEmployeeById(i);
    }

}
