/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author hyngu
 */
@Configuration
public class SpringSecurityConfig {
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        return b;
    }
    
}
