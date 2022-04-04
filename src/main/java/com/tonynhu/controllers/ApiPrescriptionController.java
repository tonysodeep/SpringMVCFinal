/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.controllers;

import com.tonynhu.pojos.Pres;
import com.tonynhu.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
