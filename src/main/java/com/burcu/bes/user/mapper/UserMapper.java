package com.burcu.bes.user.mapper;

import com.burcu.bes.user.model.User;
import com.burcu.bes.user.request.CreateUserRequest;
import com.burcu.bes.user.request.UpdateUserRequest;
import com.burcu.bes.user.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapCreateUserRequestToUser(CreateUserRequest userRequest);
    UserResponse mapUserToUserResponse(User user);
    void mapUpdateUserFromRequest(UpdateUserRequest request, @MappingTarget User user);
}
