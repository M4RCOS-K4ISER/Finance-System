package com.example.demo.service;

import com.example.demo.dto.CreateUserDTO;
import com.example.demo.dto.LoginUserDTO;
import com.example.demo.dto.RecoveryJwtTokenDTO;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.models.UserDetailsImpl;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenService;
import com.example.demo.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfig  securityConfig;

    public RecoveryJwtTokenDTO authenticateUser(LoginUserDTO loginUserDTO){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginUserDTO.email(), loginUserDTO.password());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return new RecoveryJwtTokenDTO(jwtTokenService.generateToken(userDetails));
    }

    public void createUser(CreateUserDTO createUserDTO){
        User newUser = User.builder()
                .email(createUserDTO.email())
                .password(securityConfig.passwordEncoder().encode(createUserDTO.password()))
                .roles(List.of(Role.builder().name(createUserDTO.role()).build()))
                .build();

        userRepository.save(newUser);
    }
}
