package com.burcu.bes.user.controller;

import com.burcu.bes.user.request.CreateUserRequest;
import com.burcu.bes.user.response.UserResponse;
import com.burcu.bes.user.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("create-user")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest userRequest) {
        return ResponseEntity.ok(userServiceImpl.createUser(userRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userServiceImpl.getUserById(id));
    }
}
