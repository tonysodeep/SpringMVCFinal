/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.repository;

import com.tonynhu.pojos.Employee;
import com.tonynhu.pojos.Schedule;
import java.util.List;

/**
 *
 * @author hyngu
 */
public interface DoctorRepository {

    List<Schedule> getSchedules(String kw, int page);

    List<Employee> getDoctors(String kw, int page);

}
