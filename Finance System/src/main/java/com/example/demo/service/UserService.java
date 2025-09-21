package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {this.userRepository = userRepository;this.passwordEncoder = passwordEncoder;}

    @Transactional
    public User createUser(User user) {
        UserDTO newUser = new UserDTO();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setCpf(user.getCpf());
        String password=passwordEncoder.encode(user.getPass_hash());
        newUser.setPassword(password);
        return userRepository.save(user);
    }
    @Transactional
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));
    }
    @Transactional
    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }
    @Transactional
    public User getUserByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }
    @Transactional
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Transactional
    public User updateUser(Long id) {
        return userRepository.save(new  User());
    }
}
