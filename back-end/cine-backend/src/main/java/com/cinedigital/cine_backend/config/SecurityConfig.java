package com.cinedigital.cine_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Se usará el algoritmo BCrypt para encriptar los valores.
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity requestHttp) throws Exception {
        /*
         * Se desactiva el CSRF (Cross-Site Request Forgery (Falsificación de Peitición
         * en Sitios Cruzados)) ya que se va a usar un modelo API REST/Postman, esto
         * permitirá
         * recibir cualquier petición. Además, para el incio de sesión se va a usar
         * Tokens JWT
         * y el ataque ya no podría ocurri porque ya no se están usando cookies.
         */
        requestHttp.csrf(csfr -> csfr.disable()).authorizeHttpRequests(
                auth -> auth.anyRequest().permitAll() // Se autorizan todas las peticiones.
        );

        return requestHttp.build();
    }
}
