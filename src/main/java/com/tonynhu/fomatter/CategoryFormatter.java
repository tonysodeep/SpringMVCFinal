/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.fomatter;

import com.tonynhu.pojos.Category;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author hyngu
 */
public class CategoryFormatter implements Formatter<Category> {

    @Override
    public String print(Category t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Category parse(String catId, Locale locale) throws ParseException {
        Category c = new Category();
        c.setId(Integer.parseInt(catId));
        return c;
    }

}
