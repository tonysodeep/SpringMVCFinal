/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.controllers;

import com.tonynhu.pojos.Category;
import com.tonynhu.pojos.Pres;
import com.tonynhu.service.DoctorService;
import com.tonynhu.service.MedicineService;
import com.tonynhu.utils.Utils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/doctor")
@Controller
@ControllerAdvice
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private MedicineService medicineService;

    @ModelAttribute
    public void commonAttributes(Model model, HttpSession session) {
        model.addAttribute("presStats", Utils.presStats((Map<Integer, Pres>) session.getAttribute("pres")));
    }

    @RequestMapping("/")
    public String schedul(Model model,
            @RequestParam(name = "kw", required = false) String kw,
            @RequestParam(name = "page", defaultValue = "1") Integer page) {
        model.addAttribute("schedules", this.doctorService.getSchedules(kw, page));
        return "doctor/index";
    }

    @RequestMapping("/add-precription/{scheduleId}")
    public String add(Model model,
            @RequestParam(name = "kw", required = false) String kw,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "categoryId", required = false, defaultValue = "") String categoryId,
            HttpSession session,
            @PathVariable(name = "scheduleId") int id) {
        session.setAttribute("sheduleId", id);
        Map<String, String> params = new HashMap<>();
        params.put("kw", kw);
        params.put("categoryId", categoryId);
        model.addAttribute("medicines", this.medicineService.getMedicines(params, page));
        model.addAttribute("medicineCounter", this.medicineService.countMedicines());
        return "doctor/add-pres";
    }
}
