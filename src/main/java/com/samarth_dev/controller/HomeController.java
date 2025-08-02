package com.samarth_dev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String HomeControllerHandler(){
        return  "Welcome to Next Generation E-Commerce Application";
    }
}
