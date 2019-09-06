package com.radek.store.controllers;

import com.radek.store.annotation.*;
import com.radek.store.dto.users.AuthenticatedUserDTO;
import com.radek.store.dto.users.PatchUserDTO;
import com.radek.store.dto.users.UserDTO;
import com.radek.store.entity.users.Employee;
import com.radek.store.entity.users.User;
import com.radek.store.mapper.UserMapper;
import com.radek.store.security.CurrentUser;
import com.radek.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @IsAuthenticated
    @GetMapping("/user")
    public AuthenticatedUserDTO getCurrentUser() {
        return userMapper.toAuthenticatedUserDTO(currentUser.getUser());
    }


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
    public ResponseEntity<Object> getByUsername(@PathVariable String username) {
        Optional<User> user = userService.getCurrentUser();
        if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))) {
            return ResponseEntity.ok().body(userMapper.toAdminDTO(userService.findByUsername(username)));

        } else if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_EMPLOYEE"))) {
            return ResponseEntity.ok().body(userMapper.toEmployeeDTO(userService.findByUsername(username)));

        } else {
            return ResponseEntity.ok().body(userMapper.toDTO(userService.findByUsername(username)));
        }
    }

    @PostMapping("/users")
    public UserDTO postUser(@RequestBody User user) {
        return userMapper.toDTO(userService.save(user));
    }


    //do sprawdzenia
    @IsEmployeeOrCurrentUser
    @PatchMapping("/users/{username}")
    public UserDTO updateUser(@PathVariable String username, @RequestBody PatchUserDTO patchUserDTO) {
        User user = userService.findByUsername(username);
        Optional<User> currentUser = userService.getCurrentUser();

        if (patchUserDTO.getName() != null) {
            user.setName(patchUserDTO.getName());
        }
        if (patchUserDTO.getSurname() != null) {
            user.setSurname(patchUserDTO.getSurname());
        }
        if (patchUserDTO.getUsername() != null) {
            user.setUsername(patchUserDTO.getUsername());
        }
        if (patchUserDTO.getEmail() != null) {
            user.setEmail(patchUserDTO.getEmail());
        }
        if (patchUserDTO.getPhoneNumber() != null) {
            user.setPhoneNumber(patchUserDTO.getPhoneNumber());
        }


        if (currentUser.isPresent() && currentUser.get() instanceof Employee) {
            if (patchUserDTO.getExpired() != null) {
                user.setExpired(patchUserDTO.getExpired());
            }
            if (patchUserDTO.getLocked() != null) {
                user.setLocked(patchUserDTO.getLocked());
            }
            if (patchUserDTO.getCredentialsExpired() != null) {
                user.setCredentialsExpired(patchUserDTO.getCredentialsExpired());
            }
            if (patchUserDTO.getEnabled() != null) {
                user.setEnabled(patchUserDTO.getEnabled());
            }
        }

        return userMapper.toDTO(userService.save(user));


    }

    //do sprawdzenia
    @IsAuthenticated
    @PatchMapping("/user")
    public UserDTO updateCurrentUser (@PathVariable String username, @RequestBody PatchUserDTO patchUserDTO) {
        User user = userService.findByUsername(username);

        if (patchUserDTO.getName() != null) {
            user.setName(patchUserDTO.getName());
        }
        if (patchUserDTO.getSurname() != null) {
            user.setSurname(patchUserDTO.getSurname());
        }
        if (patchUserDTO.getUsername() != null) {
            user.setUsername(patchUserDTO.getUsername());
        }
        if (patchUserDTO.getEmail() != null) {
            user.setEmail(patchUserDTO.getEmail());
        }
        if (patchUserDTO.getPhoneNumber() != null) {
            user.setPhoneNumber(patchUserDTO.getPhoneNumber());
        }

        return userMapper.toDTO(userService.save(user));
    }



    @IsEmployeeOrCurrentUser
    @DeleteMapping("/users/{username}")
    public void deleteByUsername(@PathVariable String username) {
        userService.deleteByUsername(username);
    }

    @IsAdmin
    @DeleteMapping("/user")
    public ResponseEntity<Object> deleteCurrentUser() {
        return ResponseEntity.ok().body(userService.deleteByUsername(currentUser.getUser().getUsername()));
    }
}
