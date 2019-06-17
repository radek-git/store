package com.radek.store.controllers;

import com.radek.store.dto.users.UserDTO;
import com.radek.store.entity.users.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {




    @GetMapping("/user")
    public UserDTO getCurrentUser() {

    }


    @PatchMapping("/user")
    public UserDTO updateCurrentUser(@RequestBody User user) {

    }

    @DeleteMapping("/user")
    public ResponseEntity<Object> deleteCurrentUser() {

    }


    @GetMapping("/users")
    public List<UserDTO> getAll() {

    }



    @GetMapping("/users/{username}")
    public UserDTO getByUsername(@PathVariable String username) {

    }


    @PostMapping("/users")
    public UserDTO postUser(@RequestBody User user) {

    }


    @PatchMapping("/users/{username}")
    public UserDTO updateUser(@PathVariable String username, @RequestBody User user) {

    }


    @DeleteMapping("/users/{username}")
    public void deleteByUsername(@PathVariable String username) {

    }
}
