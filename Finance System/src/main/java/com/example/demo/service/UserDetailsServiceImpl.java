package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.models.UserDetailsImpl;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        try{
            User user=userRepository.findByEmail(username);
            return new UserDetailsImpl(user);
        }catch(Exception e){
            throw new RuntimeException("Usuário não encontrado.");
        }
    }
}
