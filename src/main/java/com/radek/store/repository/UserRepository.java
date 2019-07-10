package com.radek.store.repository;


import com.radek.store.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByNameAndSurname(String name, String surname);

    Optional<User> findByPhoneNumber(String phoneNumber);

    long deleteByUsername(String username);
}
