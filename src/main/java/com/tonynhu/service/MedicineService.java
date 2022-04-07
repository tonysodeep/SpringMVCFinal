/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tonynhu.service;

import com.tonynhu.pojos.Medicine;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hyngu
 */
public interface MedicineService {

    List<Medicine> getMedicines(Map<String,String> params, int page);

    int countMedicines();

    boolean addOrUpdateProduct(Medicine m);

    Medicine getMedicineById(int id);
}
