package com.codeup.codeup_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
//    @ResponseBody
//    public String hello() {
//        return "This is the landing page!";
//    }
//    return "home";
    public String welcome(){return "home";}

}
