package org.perscholas.foodorderwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController{

    //index page
    @GetMapping({"/index"})
    public String index(){
        return "index";
    }

    //login page
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}