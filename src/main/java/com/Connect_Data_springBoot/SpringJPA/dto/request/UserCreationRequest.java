package com.Connect_Data_springBoot.SpringJPA.dto.request;

import com.Connect_Data_springBoot.SpringJPA.exception.ErrorCode;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {

    @Size(min=3, message = "USERNAME_INVALID")
     String username;
    @Size(min=8, message= "PASSWORD_INVALID")
     String password;
     String firstname;
     String lastname;
     LocalDate dob;

}
