package com.Connect_Data_springBoot.SpringJPA.Service;

import com.Connect_Data_springBoot.SpringJPA.Entity.User;
import com.Connect_Data_springBoot.SpringJPA.dto.request.UserCreationRequest;
import com.Connect_Data_springBoot.SpringJPA.dto.request.UserUpdateRequest;
import com.Connect_Data_springBoot.SpringJPA.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRespository userRespository;

    public User createUser(UserCreationRequest request){
        User user= new User();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());

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

        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());

        return userRespository.save(user);
    }

    public void deleteUser(String userId){
        userRespository.deleteById(userId);
    }
}
