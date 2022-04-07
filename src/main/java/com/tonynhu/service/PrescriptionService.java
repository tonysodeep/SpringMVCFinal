/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tonynhu.service;

import com.tonynhu.pojos.Pres;
import java.util.Map;

/**
 *
 * @author hyngu
 */
public interface PrescriptionService {

    boolean addPrescription(Map<Integer, Pres> pres, int scheduleId);
}
