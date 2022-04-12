/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.controllers;

import com.tonynhu.pojos.Employee;
import com.tonynhu.pojos.Medicine;
import com.tonynhu.service.CategoryService;
import com.tonynhu.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
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

    @RequestMapping("/update-medicine/{medicineId}")
    public String updateMedicineView(Model model,
            @PathVariable(name = "medicineId") int id) {

        Medicine medicine = medicineService.getMedicineById(id);
        System.out.println("descritption " + medicine.getDescription());
        model.addAttribute("medicineUpdate", medicine);
        return "admin/updateMedicine";
    }

    @PostMapping("/update-medicine/{medicineId}")
    public String updateMedicine(Model model,
            @ModelAttribute(value = "medicineUpdate") Medicine medicine,
            @PathVariable(name = "medicineId") int id) {
        System.out.println("controller id" + id);
        Medicine existMedicine = medicineService.getMedicineById(id);
        existMedicine.setName(medicine.getName());
        existMedicine.setPrice(medicine.getPrice());
        existMedicine.setDescription(medicine.getDescription());
        if (this.medicineService.addOrUpdateProduct(medicine)) {
            return "redirect:/admin/medicine";
        } else {
            model.addAttribute("errMsg", "Something wrong please try agian");
            return "addmin/medicine";
        }
    }

    @RequestMapping("/del-medi/{medicineId}")
    public String deleteMedicine(Model model,
            @PathVariable(name = "medicineId") int id) {
        Medicine existMedicine = medicineService.getMedicineById(id);
        this.medicineService.deleteMedicine(existMedicine);
        return "redirect:/admin/medicine";
    }

}
