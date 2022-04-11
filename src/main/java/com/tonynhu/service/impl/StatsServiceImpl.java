/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.service.impl;

import com.tonynhu.repository.StatsRepository;
import com.tonynhu.service.StatsService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hyngu
 */
@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private StatsRepository statsRepository;

    @Override
    public List<Object[]> couteCates() {
        return this.statsRepository.couteCates();
    }

    @Override
    public List<Object[]> medicineRevenue(String kw, String fromDate, String toDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fd = null;
        Date td = null;
        if (fromDate != null && !fromDate.isEmpty()) {
            try {
                fd = format.parse(fromDate);
            } catch (ParseException ex) {
                Logger.getLogger(StatsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (toDate != null && !toDate.isEmpty()) {
            try {
                td = format.parse(toDate);
            } catch (ParseException ex) {
                Logger.getLogger(StatsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.statsRepository.medicineRevenue(kw, fd, td);
    }

}
