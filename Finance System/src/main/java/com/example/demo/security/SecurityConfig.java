package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Autoriza todas as requisições HTTP sem autenticação
                //.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("/login","register").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form-> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/", true)
                    .permitAll()
                )
                .logout(logout->logout
                    .permitAll()
                )
                .csrf(csrf->csrf
                    .ignoringRequestMatchers("/h2-console/**")
                )
                .headers(headers->headers
                        .frameOptions(frameOptions->frameOptions.sameOrigin())
                );
        return http.build();
    }
}
