package com.msa.user.service;

import com.msa.user.DTO.UserDto;
import com.msa.user.jpa.UserEntity;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);

    Iterable<UserEntity> getUserByAll();
}
