package com.cms.user_module.config;

import com.cms.user_module.filter.JwtAuthFilter;
import com.cms.user_module.service.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomerUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/customer/add").permitAll() // Allow anyone to add a customer
                .antMatchers("/api/login").permitAll() // Allow anyone to login
                .antMatchers("/api/permission/**").hasRole("ADMIN") // Require ADMIN role for permission endpoints
                .antMatchers("/api/role/**").hasRole("ADMIN") // Require ADMIN role for role endpoints
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtAuthFilter(authenticationManager()))
                .formLogin()
                .and()
                .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Use a strong password encoder
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
