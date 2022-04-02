/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tonynhu.service;

import com.tonynhu.pojos.Medicine;
import java.util.List;

/**
 *
 * @author hyngu
 */
public interface MedicineService {

    List<Medicine> getMedicines(String kw, int page);

    int countMedicines();

    boolean addOrUpdateProduct(Medicine m);

    Medicine getMedicineById(int id);
}
