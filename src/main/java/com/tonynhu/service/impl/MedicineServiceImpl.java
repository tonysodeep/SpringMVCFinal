/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tonynhu.pojos.Medicine;
import com.tonynhu.repository.MedicineRepository;
import com.tonynhu.service.MedicineService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hyngu
 */
@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Medicine> getMedicines(Map<String, String> params, int page) {
        return this.medicineRepository.getMedicines(params, page);
    }

    @Override
    public int countMedicines() {
        return this.medicineRepository.countMedicines();
    }

    @Override
    public boolean addOrUpdateProduct(Medicine m) {
        System.out.println("medi service " + m.getId());
        if (m.getId() != null) {
            return this.medicineRepository.addOrUpdateProduct(m);
        } else {
            if (m.getFile() != null) {
                try {
                    Map res = this.cloudinary.uploader().upload(m.getFile().
                            getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                    m.setImage((String) res.get("secure_url"));
                } catch (IOException ex) {
                    Logger.getLogger(MedicineServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return this.medicineRepository.addOrUpdateProduct(m);
        }

    }

    @Override
    public Medicine getMedicineById(int i) {
        return this.medicineRepository.getMedicineById(i);
    }

    @Override
    public void deleteMedicine(Medicine mdcn) {
        this.medicineRepository.deleteMedicine(mdcn);
        return;
    }

}
