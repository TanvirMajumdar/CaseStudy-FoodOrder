package org.perscholas.foodorderwebapp.controllers;

import org.perscholas.foodorderwebapp.models.Item;
import org.perscholas.foodorderwebapp.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    //to show food item list to the customer
    @GetMapping("/menu")
    public String menu(Model model){
        List<Item> foodItems = itemService.listAll();
        model.addAttribute("foodItems", foodItems);
        return "menu";
    }
}
