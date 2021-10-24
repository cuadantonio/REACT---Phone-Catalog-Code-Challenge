package com.codechallenge.backend.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.antMatcher("/api/**");
        httpSecurity.authorizeRequests().anyRequest().permitAll();
        httpSecurity.csrf().disable();
        httpSecurity.httpBasic().disable();
        httpSecurity.formLogin().disable();
    }
}
