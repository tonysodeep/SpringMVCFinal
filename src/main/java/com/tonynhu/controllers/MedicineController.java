/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.controllers;

import com.tonynhu.pojos.Medicine;
import com.tonynhu.service.CategoryService;
import com.tonynhu.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hyngu
 */
@Controller
@RequestMapping("/admin")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/add-medicine")
    public String addView(Model model) {
        model.addAttribute("medicine", new Medicine());
        return "add-medicine";
    }

    @PostMapping("/add-medicine")
    public String addHandler(Model model,
            @ModelAttribute(value = "medicine") Medicine m) {
        if (this.medicineService.addOrUpdateProduct(m) == true) {
            return "redirect:/admin/";
        } else {
            model.addAttribute("errMsg", "Something wrong please try agian");
            return "add-medicine";
        }
    }

  
}
