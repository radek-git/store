package com.radek.store.security;

import com.radek.store.entity.users.User;
import com.radek.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrentUserImpl implements CurrentUser{

    private UserRepository userRepository;

    @Autowired
    public CurrentUserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser() {
        return userRepository.findByUsername(SecurityUtils.getUsername()).orElseThrow(() -> new RuntimeException("Nie ma"));
    }
}
