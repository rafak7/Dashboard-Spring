package com.analyzer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().permitAll() // Permitir acesso a todas as rotas sem autenticação
                )
                .formLogin().disable() // Desabilitar a página de login temporariamente
                .logout().disable(); // Desabilitar logout temporariamente

        return http.build();
    }
}
