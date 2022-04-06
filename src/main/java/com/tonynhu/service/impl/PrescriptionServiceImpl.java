/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.service.impl;

import com.tonynhu.pojos.Pres;
import com.tonynhu.repository.PrescriptionRepository;
import com.tonynhu.service.PrescriptionService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hyngu
 */
@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public boolean addPrescription(Map<Integer, Pres> pres, int scheduleId) {
        return this.prescriptionRepository.addPrescription(pres, scheduleId);
    }

}
