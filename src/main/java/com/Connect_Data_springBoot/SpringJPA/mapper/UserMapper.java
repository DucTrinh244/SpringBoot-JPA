package com.Connect_Data_springBoot.SpringJPA.mapper;

import com.Connect_Data_springBoot.SpringJPA.Entity.User;
import com.Connect_Data_springBoot.SpringJPA.dto.request.UserCreationRequest;
import com.Connect_Data_springBoot.SpringJPA.dto.request.UserUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    void UpdateUser(@MappingTarget User user, UserUpdateRequest request);
}
