/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tonynhu.repository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author hyngu
 */
public interface StatsRepository {

    List<Object[]> couteCates();

    List<Object[]> medicineRevenue(String kw, Date fromDate, Date toDate);
}
