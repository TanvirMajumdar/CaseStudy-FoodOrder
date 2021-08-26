package org.perscholas.foodorderwebapp.controllers;

import org.perscholas.foodorderwebapp.models.FoodItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController{

    //index page
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    //login page
    @GetMapping("/login")
    public String login(){
        return "login";
    }


}