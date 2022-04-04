/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hyngu
 */
@Controller
@RequestMapping("/doctor")
public class PrescriptionController {

    @GetMapping("/prescription/{scheduleId}")
    public String prescription(Model model,
            HttpSession session) {
        model.addAttribute("pres", session.getAttribute("pres"));
        return "doctor/prescription";
    }
}
