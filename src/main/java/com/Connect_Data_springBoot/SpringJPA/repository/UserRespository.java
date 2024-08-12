package com.Connect_Data_springBoot.SpringJPA.repository;

import com.Connect_Data_springBoot.SpringJPA.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User, String> {
}
