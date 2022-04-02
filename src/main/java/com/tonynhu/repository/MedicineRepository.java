/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tonynhu.repository;

import com.tonynhu.pojos.Medicine;
import java.util.List;

/**
 *
 * @author hyngu
 */
public interface MedicineRepository {

    List<Medicine> getMedicines(String kw, int page);

    int countMedicines();

    boolean addOrUpdateProduct(Medicine m);
}
