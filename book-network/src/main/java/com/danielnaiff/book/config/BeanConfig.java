package com.danielnaiff.book.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {

//    O que está acontecendo aqui?
//
//    Você está criando e configurando um DaoAuthenticationProvider, que:
//
//    Usa o UserDetailsService para carregar os dados do usuário.
//
//    Compara a senha digitada com a senha armazenada no banco de dados usando o PasswordEncoder.
//
//            Etapas:
//
//    Cria uma instância de DaoAuthenticationProvider.
//
//    Define o UserDetailsService (responsável por buscar o usuário).
//
//    Define o PasswordEncoder (responsável por verificar a senha criptografada).
//
//    Retorna o objeto como bean do Spring.

    private final UserDetailsService userDetailService;

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
