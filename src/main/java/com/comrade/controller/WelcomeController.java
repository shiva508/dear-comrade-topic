package com.comrade.controller;

import com.comrade.model.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public CommonResponse welcome(){
        return CommonResponse.builder().message("Welcome to dear-comrade-topic").statusCode(200).timeStamp(new Date()).build();
    }
}
