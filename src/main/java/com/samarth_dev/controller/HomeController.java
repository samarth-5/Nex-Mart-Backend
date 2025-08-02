package com.samarth_dev.controller;

import com.samarth_dev.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ApiResponse HomeControllerHandler(){
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setMessage("Welcome to Next Generation E-Commerce Application");
        return  apiResponse;
    }
}
