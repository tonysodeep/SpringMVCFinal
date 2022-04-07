/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.controllers;

import com.tonynhu.pojos.Category;
import com.tonynhu.service.CategoryService;
import com.tonynhu.service.MedicineService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hyngu
 */
@Controller
@ControllerAdvice
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MedicineService medicineService;

    @ModelAttribute
    public void commonAttributes(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
    }

    @RequestMapping("/")
    public String admin() {
        return "admin/index";
    }

    @RequestMapping("/medicine")
    public String medicine(Model model,
            @RequestParam(name = "kw", required = false) String kw,
            @RequestParam(name = "categoryId", required = false, defaultValue = "") String categoryId,
            @RequestParam(name = "page", defaultValue = "1") Integer page) {

        Map<String, String> params = new HashMap<>();
        params.put("kw", kw);
        params.put("categoryId", categoryId);

        model.addAttribute("medicines", this.medicineService.getMedicines(params, page));
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
    public String medicineDetail(Model model,
            @PathVariable(name = "medicineId") int id) {
        model.addAttribute("medicine", this.medicineService.getMedicineById(id));
        return "medicine-detail";
    }

}
