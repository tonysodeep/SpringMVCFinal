/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.controllers;

import com.tonynhu.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hyngu
 */
@Controller
@RequestMapping("/admin")
public class AdminStatsController {

    @Autowired
    private StatsService statsService;

    @RequestMapping("/cates-stats")
    public String cateStats(Model model) {
        model.addAttribute("stats", this.statsService.couteCates());
        return "admin/cates-stats";
    }

    @RequestMapping("/revenue-stats")
    public String revenueStats() {
        return "admin/revenue-stats";
    }

}
