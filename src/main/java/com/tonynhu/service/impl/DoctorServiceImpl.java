/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.service.impl;

import com.tonynhu.pojos.Schedule;
import com.tonynhu.repository.DoctorRepository;
import com.tonynhu.service.DoctorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hyngu
 */
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Schedule> getSchedules(String kw, int page) {
        return doctorRepository.getSchedules(kw, page);
    }

}
