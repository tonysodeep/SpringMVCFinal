/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.controllers;

import com.tonynhu.service.StatsService;
import org.eclipse.persistence.annotations.ReadOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hyngu
 */
@Controller
@RequestMapping("/admin")
public class AdminStatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/cates-stats")
    public String cateStats(Model model) {
        model.addAttribute("stats", this.statsService.couteCates());
        return "admin/cates-stats";
    }

    @GetMapping("/revenue-stats")
    public String revenueStats(Model model,
            @RequestParam(name = "kw", defaultValue = "") String kw, 
            @RequestParam(name = "fromDate", defaultValue = "") String fromDate,
            @RequestParam(name = "toDate", defaultValue = "") String toDate
    ) {
        model.addAttribute("stats", this.statsService.medicineRevenue(kw, fromDate, toDate));
        return "admin/revenue-stats";
    }

}
