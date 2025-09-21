package com.burcu.bes.user.mapper;

import com.burcu.bes.user.model.User;
import com.burcu.bes.user.request.CreateUserRequest;
import com.burcu.bes.user.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapCreateUserRequestToUser(CreateUserRequest userRequest);
    UserResponse mapUserToUserResponse(User user);
}
