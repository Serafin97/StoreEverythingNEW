package com.example.storeeverything.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();

        httpSecurity.authorizeRequests()
                .antMatchers("/*", "/css/**", "/js/**", "/images/**", "/webjars/**","/h2/**","/" ).permitAll();
/*               .antMatchers("/index").hasAnyAuthority("L_USER", "F_USER", "ADMIN")
                .antMatchers("/informations/**").hasAnyAuthority("F_USER", "ADMIN")
                .antMatchers("/informations_limited/**").hasAnyAuthority("L_USER", "F_USER", "ADMIN")
                .antMatchers("/user/**").hasAnyAuthority("L_USER", "F_USER", "ADMIN")
                .antMatchers("/categories/**").hasAnyAuthority("ADMIN")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                *//*.loginPage("/login")*//*
                .usernameParameter("login")
                .defaultSuccessUrl("/afterLoggingIn")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/?logout").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error/403");*/


    }
}
