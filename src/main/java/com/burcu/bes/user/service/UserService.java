package com.burcu.bes.user.service;

import com.burcu.bes.user.request.CreateUserRequest;
import com.burcu.bes.user.response.UserResponse;

public interface UserService {
    UserResponse createUser(CreateUserRequest userRequest);
    UserResponse getUserById(Long id);
}
