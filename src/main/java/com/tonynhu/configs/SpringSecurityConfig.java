/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonynhu.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tonynhu.handlers.LoginSuccessHandler;
import com.tonynhu.handlers.LogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author hyngu
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.tonynhu.service",
    "com.tonynhu.repository",
    "com.tonynhu.handlers"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Autowired
    private LogoutHandler logoutHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        return b;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().usernameParameter("email").passwordParameter("password");

        http.formLogin().loginPage("/login")
                .failureUrl("/login?err");

        http.formLogin().successHandler(loginSuccessHandler);

        http.logout().logoutSuccessHandler(logoutHandler);

        http.exceptionHandling()
                .accessDeniedPage("/login?accessDenied");

//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/admin/**")
//                .access("hasRole('ADMIN')")
//                .antMatchers("/doctor/**")
//                .access("hasRole('DOCTOR')");

        http.csrf().disable();
    }

    @Bean
    public Cloudinary cloudinary() {

        Cloudinary c = new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name", "tonysodeep",
                        "api_key", "887976783892321",
                        "api_secret", "yL2d2QXta1A_5D8d1kDpFvF0wtM",
                        "secure", true
                )
        );
        return c;
    }

}
