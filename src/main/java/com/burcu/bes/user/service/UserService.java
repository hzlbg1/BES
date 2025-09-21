package com.burcu.bes.user.service;

import com.burcu.bes.user.request.CreateUserRequest;
import com.burcu.bes.user.request.UpdateUserRequest;
import com.burcu.bes.user.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(CreateUserRequest userRequest);
    UserResponse getUserById(Long id);
    List<UserResponse> getAllUsers();
    UserResponse updateUser(Long id, UpdateUserRequest userRequest);
}
