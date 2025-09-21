package com.burcu.bes.user.service;

import com.burcu.bes.user.mapper.UserMapper;
import com.burcu.bes.user.model.User;
import com.burcu.bes.user.repository.UserRepository;
import com.burcu.bes.user.request.CreateUserRequest;
import com.burcu.bes.user.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse createUser(CreateUserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail()))
            throw new IllegalArgumentException("Bu email ile kayıtlı kullanıcı zaten var!");

        User user = userMapper.mapCreateUserRequestToUser(userRequest);
        return userMapper.mapUserToUserResponse(userRepository.save(user));
    }

    @Override
    public UserResponse getUserById(Long id) throws ResponseStatusException {
        return userRepository.findById(id)
                .map(userMapper::mapUserToUserResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Kullanıcı bulunamadı!"));
    }
}
