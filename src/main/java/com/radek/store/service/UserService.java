package com.radek.store.service;

import com.radek.store.entity.users.User;
import com.radek.store.repository.UserRepository;
import com.radek.store.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getCurrentUser() {
        return userRepository.findByUsername(SecurityUtils.getUsername());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("NIe ma"));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("NIe ma"));
    }


    public User findByNameAndSurname(String name, String surname) {
        return userRepository.findByNameAndSurname(name, surname).orElseThrow(() -> new RuntimeException("NIe ma"));
    }

    public User findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new RuntimeException("NIe ma"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }


    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }
}
