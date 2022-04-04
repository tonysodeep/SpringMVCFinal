/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.utils;

import com.tonynhu.pojos.Pres;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hyngu
 */
public class Utils {

    public static Map<String, String> presStats(Map<Integer, Pres> pres) {
        int totalQuantity = 0;
        int totalAmount = 0;
        if (pres != null) {
            for (Pres p : pres.values()) {
                totalQuantity += p.getQuantity();
                totalAmount += p.getQuantity() * p.getPrice();
            }
        }
        Map<String, String> result = new HashMap<>();
        result.put("totalAmount", String.valueOf(totalAmount));
        result.put("totalQuantity", String.valueOf(totalQuantity));

        return result;

    }
}
