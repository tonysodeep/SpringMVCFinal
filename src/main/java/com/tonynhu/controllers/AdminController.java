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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MedicineService medicineService;

    @RequestMapping("/")
    public String admin() {
        return "admin/index";
    }

    @RequestMapping("/medicine")
    public String medicine(Model model,
            @RequestParam(name = "kw", required = false) String kw,
            @RequestParam(name = "page", defaultValue = "1") Integer page) {

        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("medicines", this.medicineService.getMedicines(kw, page));
        model.addAttribute("medicineCounter", this.medicineService.countMedicines());
        List<Category> cates = this.categoryService.getCategories();
        for (Category cate : cates) {
            System.out.println(cate.toString());
        }
        return "admin/medicine";
    }

    @RequestMapping("/doctor")
    public String doctor() {
        return "admin/doctor";
    }

    @RequestMapping("/medicine/{medicineId}")
    public String medicineDetail(@PathVariable(name = "medicineId") int id) {
        return "medicine-detail";
    }

}
