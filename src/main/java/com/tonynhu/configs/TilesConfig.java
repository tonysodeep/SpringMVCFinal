/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 *
 * @author hyngu
 */
@Configuration
public class TilesConfig {
    
    @Bean
    public UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        
        resolver.setViewClass(TilesView.class);
        resolver.setOrder(-2);
        
        return resolver;
    }
    
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer c = new TilesConfigurer();
        c.setDefinitions("/WEB-INF/tiles.xml");
        c.setCheckRefresh(true);
        return c;
    }
}
