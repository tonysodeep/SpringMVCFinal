/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.repository.impl;

import com.tonynhu.pojos.Medicine;
import com.tonynhu.pojos.Pres;
import com.tonynhu.pojos.Prescription;
import com.tonynhu.pojos.PrescriptionDetail;
import com.tonynhu.pojos.Schedule;
import com.tonynhu.repository.MedicineRepository;
import com.tonynhu.repository.PrescriptionRepository;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hyngu
 */
@Repository
public class PrescriptionRepositoryImpl implements PrescriptionRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addPrescription(Map<Integer, Pres> pres, int scheduleId) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();

        try {
            Schedule schedule = s.get(Schedule.class, scheduleId);
            Prescription p = new Prescription();
            
            int createPrescriptionId = (Integer) s.save(p);
            Prescription createPrescription = s.get(Prescription.class, createPrescriptionId);
            System.out.println(createPrescription.toString());
            schedule.setPrescription(createPrescription);
            s.save(schedule);

            if (pres != null) {
                for (Pres precription : pres.values()) {
                    PrescriptionDetail d = new PrescriptionDetail();
                    d.setPrescriptionId(p);
                    d.setMedicineId(this.medicineRepository.getMedicineById(p.getId()));
                    d.setQuantity(precription.getQuantity());
                    d.setPrice(precription.getPrice());
                    s.save(d);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
