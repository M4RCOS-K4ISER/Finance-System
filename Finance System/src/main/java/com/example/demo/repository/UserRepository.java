package com.example.demo.repository;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);

    User findByCpf(String cpf);

    Optional<User> findByEmail(String email);
}
