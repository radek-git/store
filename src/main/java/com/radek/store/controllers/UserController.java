package com.radek.store.controllers;

import com.radek.store.dto.users.UserDTO;
import com.radek.store.entity.users.User;
import com.radek.store.mapper.UserMapper;
import com.radek.store.security.CurrentUser;
import com.radek.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    @DeleteMapping("/user")
//    public ResponseEntity<Object> deleteCurrentUser() {
//        String username = currentUser.getUser().getUsername();;
//        if (currentUser.getUser() != null) {
//            userService.deleteByUsername(username);
//        }
//    }


    @GetMapping("/users")
    public List<UserDTO> getAll() {
        return userMapper.toDTO(userService.findAll());
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
}
