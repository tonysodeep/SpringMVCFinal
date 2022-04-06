/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.controllers;

import com.tonynhu.pojos.Pres;
import com.tonynhu.service.PrescriptionService;
import com.tonynhu.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hyngu
 */
@RestController
@RequestMapping("/api")
public class ApiPrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping("/add-pres")
    public ResponseEntity<Map<String, String>> addToPres(HttpSession session,
            @RequestBody Pres p) {
        Map<Integer, Pres> pres = (Map<Integer, Pres>) session.getAttribute("pres");
        if (pres == null) {
            pres = new HashMap<>();
        }
        if (pres.containsKey(p.getId()) == true) {
            Pres p1 = pres.get(p.getId());
            p1.setQuantity(p1.getQuantity() + 1);
        } else {
            pres.put(p.getId(), p);
        }
        session.setAttribute("pres", pres);

        return new ResponseEntity<>(Utils.presStats(pres), HttpStatus.OK);
    }

    @PutMapping("/update-pres")
    public ResponseEntity<Map<String, String>> updatePrescription(
            HttpSession session,
            @RequestBody Map<String, String> params
    ) {
        Map<Integer, Pres> pres = (Map<Integer, Pres>) session.getAttribute("pres");
        int id = Integer.parseInt(params.get("id"));
        if (pres != null && pres.containsKey(id) == true) {
            Pres p = pres.get(id);
            p.setQuantity(Integer.parseInt(params.get("quantity")));
            session.setAttribute("pres", pres);
            return new ResponseEntity<>(Utils.presStats(pres), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete-pres/{medicineId}")
    public ResponseEntity<Map<String, String>> deletePres(
            @ModelAttribute(name = "medicineId") int id,
            HttpSession session
    ) {
        Map<Integer, Pres> pres = (Map<Integer, Pres>) session.getAttribute("pres");
        if (pres != null && pres.containsKey(id)) {
            pres.remove(id);
            session.setAttribute("pres", pres);
            return new ResponseEntity<>(Utils.presStats(pres), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/pay")
    public ResponseEntity addPayment(HttpSession session) {
        Map<Integer, Pres> pres = (Map<Integer, Pres>) session.getAttribute("pres");
        int sheduleId = (Integer) session.getAttribute("sheduleId");
        if (pres != null) {
            if (this.prescriptionService.addPrescription((Map<Integer, Pres>) session.getAttribute("pres"), sheduleId) == true) {
                session.removeAttribute("pres");
                session.removeAttribute("sheduleId");
                return new ResponseEntity(HttpStatus.CREATED);
            }
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
