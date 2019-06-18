package com.radek.store.service;

import com.radek.store.entity.users.User;
import com.radek.store.repository.UserRepository;
import com.radek.store.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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

    public List<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("NIe ma"));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("NIe ma"));
    }


    public User save(User user) {
        return userRepository.save(user);
    }


    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


    public ResponseEntity<Object> deleteByUsername(String username) {
        return ResponseEntity.ok().body(userRepository.deleteByUsername(username));
    }
}
