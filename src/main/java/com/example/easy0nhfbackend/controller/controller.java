package com.example.easy0nhfbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    //comment sss
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    //Test commit
}
