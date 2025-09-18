package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public User createUser(User user) {
        User newUser = new  User();
        newUser.setNome(user.getNome());
        newUser.setEmail(user.getEmail());
        newUser.setCpf(user.getCpf());
        newUser.setSenha_hash(user.getSenha_hash());
        return userRepository.save(user);
    }
}
