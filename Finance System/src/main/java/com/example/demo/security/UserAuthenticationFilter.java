package com.example.demo.security;

import com.example.demo.models.User;
import com.example.demo.models.UserDetailsImpl;
import com.example.demo.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Arrays;

@Component
public class UserAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private UserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Verifica se o endpoint requer autenticação antes de processar a requisição
        if (checkIfEndpointIsNotPublic(request)){
            String token=recoveryToken(request);//Recupera o token do cabeçalho Authorization
            if (token!=null){
                String subject = jwtTokenService.getSubject(token);//Obtem o assunto do token
                User user=userRepository.findByEmail(subject);
                UserDetailsImpl userDetails=new UserDetailsImpl(user);
                //Criar um objeto de autenticação do Spring Security
                Authentication authentication=new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());
                //Define o objeto de autenticação no contexto de segurança do Spring Boot
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }else{
                throw new RuntimeException("Token ausente.");
            }
        }
        filterChain.doFilter(request,response);//Continua o processamento da requisição
    }

    private String recoveryToken(HttpServletRequest request) {
        String authorizationHeader=request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }

    private boolean checkIfEndpointIsNotPublic(HttpServletRequest request) {
        String requestURI=request.getRequestURI();
        return !Arrays.asList(SecurityAutoConfiguration.ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED).contains(requestURI);
    }
}
