/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.controllers;

import com.tonynhu.pojos.Employee;
import com.tonynhu.service.EmployeeService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hyngu
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("employee", new Employee());
        return "register";
    }

    @PostMapping("/register")
    public String registerHandler(Model model,
            @ModelAttribute(value = "employee") @Valid Employee employee,
            BindingResult result
    ) {
        if (result.hasErrors() == true) {
            return "register";
        }

        String errMsg;
        if (employee.getPassword().equals(employee.getConfirmPassword())) {
            if (this.employeeService.addEmployee(employee) == true) {
                return "redirect:/login";
            } else {
                errMsg = "Somethig wrong";
            }
        } else {
            errMsg = "Password does not match";
        }
        model.addAttribute("errMsg", errMsg);
        return "register";
    }

    @RequestMapping("/login")
    public String logInView() {
        return "login";
    }

    @RequestMapping("/update-employee/{employeeId}")
    public String updateEmployeeView(Model model,
            @PathVariable(name = "employeeId") int id) {
        Employee employee = employeeService.getEmployeeById(id);
        System.out.println("get from db" + employee.getId());
        System.out.println(employee.getFullname());
        model.addAttribute("employeeUpdate", employee);
        return "admin/updateEmployee";
    }

    @PostMapping("/update-employee/{employeeId}")
    public String updateEmployee(Model model,
            @ModelAttribute(value = "medicine") Employee existEmp,
            @PathVariable(name = "employeeId") int id) {
        Employee employee = employeeService.getEmployeeById(id);
        employee.setFullname(existEmp.getFullname());
        employee.setMobile(existEmp.getMobile());
        employee.setAddress(existEmp.getAddress());
        if (this.employeeService.addEmployee(employee)) {
            return "redirect:/admin/doctor";
        } else {
            model.addAttribute("errMsg", "Something wrong please try agian");
            return "add-medicine";
        }
    }
}
