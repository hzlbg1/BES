package com.burcu.bes.user.service;

import com.burcu.bes.user.mapper.UserMapper;
import com.burcu.bes.user.model.User;
import com.burcu.bes.user.repository.UserRepository;
import com.burcu.bes.user.request.CreateUserRequest;
import com.burcu.bes.user.response.CreateUserResponse;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail()))
            throw new IllegalArgumentException("Bu email ile kayıtlı kullanıcı zaten var!");

        User user = userMapper.mapCreateUserRequestToUser(userRequest);
        return userMapper.mapUserToCreateUserResponse(userRepository.save(user));
    }
}
