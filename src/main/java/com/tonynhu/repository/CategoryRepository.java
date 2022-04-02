/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tonynhu.repository;

import com.tonynhu.pojos.Category;
import java.util.List;

/**
 *
 * @author hyngu
 */
public interface CategoryRepository {

    List<Category> getCategories();
}
