package ru.virgusman.springtest.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloControllers {
    @Value("${hello}")
    private String hello;

    @GetMapping("/hello")
    public String hello(){
        System.out.println(this.hello);
        return "hello";
    }
}
