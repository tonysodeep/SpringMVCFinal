/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.controllers;

import com.tonynhu.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hyngu
 */
@RequestMapping("/doctor")
@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/")
    public String schedul(Model model,
            @RequestParam(name = "kw", required = false) String kw,
            @RequestParam(name = "page", defaultValue = "1") Integer page) {
        model.addAttribute("schedules", this.doctorService.getSchedules(kw, page));
        return "doctor/index";
    }
}
