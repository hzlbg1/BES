package com.burcu.bes.user.service;

import com.burcu.bes.user.mapper.UserMapper;
import com.burcu.bes.user.model.User;
import com.burcu.bes.user.repository.UserRepository;
import com.burcu.bes.user.request.CreateUserRequest;
import com.burcu.bes.user.request.UpdateUserRequest;
import com.burcu.bes.user.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::mapUserToUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse updateUser(Long id, UpdateUserRequest userRequest) {
        User user = findUserById(id);
        userMapper.mapUpdateUserFromRequest(userRequest, user);
        return userMapper.mapUserToUserResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(findUserById(id).getId());
    }

    private User findUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Kullanıcı bulunamadı " + id));
    }
}