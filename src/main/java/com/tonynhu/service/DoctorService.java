/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tonynhu.service;

import com.tonynhu.pojos.Schedule;
import java.util.List;

/**
 *
 * @author hyngu
 */
public interface DoctorService {
     List<Schedule> getSchedules(String kw, int page);
}
