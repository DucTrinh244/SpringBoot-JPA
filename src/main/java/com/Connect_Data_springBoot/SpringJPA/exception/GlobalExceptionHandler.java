package com.Connect_Data_springBoot.SpringJPA.exception;

import com.Connect_Data_springBoot.SpringJPA.dto.request.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

@ControllerAdvice
public class GlobalExceptionHandler {
//    xừ lý truòng hợp sử dụng
    @ExceptionHandler(value= Exception.class)
    ResponseEntity<ApiResponse> handlingRunTimeException(RuntimeException exception){

        ApiResponse apiResponse= new ApiResponse();
        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value= AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException exception){

        ErrorCode errorCode= exception.getErrorCode();
        ApiResponse apiResponse= new ApiResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handingMethodArgumentNotValidException(MethodArgumentNotValidException exception){

        String enumkey =exception.getFieldError().getDefaultMessage();

        ErrorCode errorCode= ErrorCode.INVALID_KEY;
        try {
            errorCode= ErrorCode.valueOf(enumkey);
        }catch (IllegalArgumentException e){

        }



        ApiResponse apiResponse=   new ApiResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return ResponseEntity.badRequest().body(apiResponse);
    }

}
