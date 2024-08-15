package com.Connect_Data_springBoot.SpringJPA.Service;

import com.Connect_Data_springBoot.SpringJPA.Entity.User;
import com.Connect_Data_springBoot.SpringJPA.dto.request.UserCreationRequest;
import com.Connect_Data_springBoot.SpringJPA.dto.request.UserUpdateRequest;
import com.Connect_Data_springBoot.SpringJPA.exception.AppException;
import com.Connect_Data_springBoot.SpringJPA.exception.ErrorCode;
import com.Connect_Data_springBoot.SpringJPA.mapper.UserMapper;
import com.Connect_Data_springBoot.SpringJPA.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRespository userRespository;
    @Autowired
    private UserMapper userMapper;
    public User createUser(UserCreationRequest request){
        if(userRespository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user= userMapper.toUser(request);

        return  userRespository.save(user);
    }

    public List<User> getUsers(){
        return userRespository.findAll();
    }

    public User getUser(String id){
        return userRespository.findById(id).orElseThrow(() -> new RuntimeException("User is not exist !"));
    }

    public User updateUser(String userId, UserUpdateRequest request){
        User user= getUser(userId);
        userMapper.UpdateUser(user,request);

        return userRespository.save(user);
    }

    public void deleteUser(String userId){
        userRespository.deleteById(userId);
    }
}
