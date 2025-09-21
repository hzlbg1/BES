package com.burcu.bes.user.service;

import com.burcu.bes.user.request.CreateUserRequest;
import com.burcu.bes.user.response.CreateUserResponse;

public interface UserService {
    CreateUserResponse createUser(CreateUserRequest userRequest);
}
