/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tonynhu.service;

import java.util.List;

/**
 *
 * @author hyngu
 */
public interface StatsService {

    List<Object[]> couteCates();

    List<Object[]> medicineRevenue(String kw, String fromDate, String toDate);
}
