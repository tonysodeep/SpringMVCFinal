/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tonynhu.service;

import com.tonynhu.pojos.Employee;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author hyngu
 */
public interface EmployeeService extends UserDetailsService{
     boolean addEmployee(Employee employee);
     Employee getEmployeeByEmail(String email);
}
