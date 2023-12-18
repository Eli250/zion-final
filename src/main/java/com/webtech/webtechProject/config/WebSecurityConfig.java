package com.webtech.webtechProject.config;

import com.webtech.webtechProject.services.CustomUserDetailsService;
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
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/signup","/","/diet", "/static/**","/Css/**","/images/**","/images", "/landing", "/static/images/**","/static/Css/**","/webjars/**","/trainer","/register", "/error").permitAll() // Allow public access
                .antMatchers("/userDash","trainerdash").authenticated()
                .antMatchers("/signup/**").permitAll()
                .antMatchers("/trainerdash").hasRole("TRAINER")
                .antMatchers("/userDash").hasRole("TRAINEE")
                .anyRequest().authenticated() // Require authentication for other endpoints
                .and()
                .formLogin()
                .loginPage("/login") // Specify your custom login page URL
                .successHandler(new CustomAuthenticationSuccessHandler()) // Set custom authentication success handler
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout") // Specify the URL to redirect after logout
                .permitAll();
    }
}