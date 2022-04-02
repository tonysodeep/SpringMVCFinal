/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.controllers;

import com.tonynhu.pojos.Category;
import com.tonynhu.service.CategoryService;
import com.tonynhu.service.MedicineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hyngu
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    @RequestMapping("/login")
    public String logIn() {
        return "login";
    }
    
    @RequestMapping("/admin-signup")
    public String signUp() {
        return "admin-signup";
    }
}
