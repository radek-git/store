package com.radek.store.controllers;

import com.radek.store.annotation.PageableDefaults;
import com.radek.store.dto.users.UserDTO;
import com.radek.store.entity.users.User;
import com.radek.store.mapper.UserMapper;
import com.radek.store.security.CurrentUser;
import com.radek.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;
    private UserMapper userMapper;
    private CurrentUser currentUser;


    @Autowired
    public UserController(UserService userService, UserMapper userMapper, CurrentUser currentUser) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.currentUser = currentUser;
    }

    @GetMapping("/user")
    public UserDTO getCurrentUser() {
        return userMapper.toDTO(currentUser.getUser());
    }


//    @PatchMapping("/user")
//    public UserDTO updateCurrentUser(@RequestBody User user) {
//
//    }


    @GetMapping("/users")
    public ResponseEntity<Object> getAll(@PageableDefaults(size = 20, minSize = 2, maxSize = 20) Pageable pageable) {

        Optional<User> user = userService.getCurrentUser();
        if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))) {
            return ResponseEntity.ok().body(userMapper.toAdminDTO(userService.findAll(pageable)));

        } else if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_EMPLOYEE"))) {
            return ResponseEntity.ok().body(userMapper.toEmployeeDTO(userService.findAll(pageable)));

        } else {
            return ResponseEntity.ok().body(userMapper.toDTO(userService.findAll(pageable)));
        }
    }



    @GetMapping("/users/{username}")
    public UserDTO getByUsername(@PathVariable String username) {
        return userMapper.toDTO(userService.findByUsername(username));
    }


    @PostMapping("/users")
    public UserDTO postUser(@RequestBody User user) {
        return userMapper.toDTO(userService.save(user));
    }



//    @PatchMapping("/users/{username}")
//    public UserDTO updateUser(@PathVariable String username, @RequestBody User user) {
//
//    }

    @DeleteMapping("/users/{username}")
    public void deleteByUsername(@PathVariable String username) {
        userService.deleteByUsername(username);
    }

    @DeleteMapping("/user")
    public ResponseEntity<Object> deleteCurrentUser() {
        return ResponseEntity.ok().body(userService.deleteByUsername(currentUser.getUser().getUsername()));
    }
}
