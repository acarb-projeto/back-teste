package com.acarb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    /**
     * Define o Bean PasswordEncoder (BCrypt) para criptografia de senhas.
     * Este bean será injetado automaticamente (Autowired) no LoginService.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCrypt é o algoritmo padrão e mais recomendado para criptografia de senhas.
        return new BCryptPasswordEncoder();
    }
}