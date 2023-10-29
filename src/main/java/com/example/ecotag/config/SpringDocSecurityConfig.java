package com.example.ecotag.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringDocSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(
                authorizeRequests -> authorizeRequests
                        .antMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                        //.antMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html")
                        //.hasAuthority("ADMIN") //관리자 권한을 가진 사람만 접속가능
                        .anyRequest()
                        .permitAll()
        )
        ;
        return http.build();
    }

}
