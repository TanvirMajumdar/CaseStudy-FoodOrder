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

    //add food item to the cart
    @GetMapping("/user/addToCart/{id}")
    public String addToCart(@PathVariable (value = "id") Long id, Model model, HttpSession session) {

        Item item = itemService.getItemById(id);
        if (session.getAttribute("process") == null) {
            Map<String, Float> cart = new HashMap<>();
            cart.put(item.getItemName(), item.getItemPrice());
            session.setAttribute("process", cart);
            model.addAttribute("cart", cart);
            Float sum = 0.0f;
            for (Float val : cart.values()) {
                sum += val;
            }
            model.addAttribute("sum", sum);
        } else {
            Map<String, Float> cart = (Map<String, Float>) session.getAttribute("process");
            cart.put(item.getItemName(), item.getItemPrice());
            session.setAttribute("process", cart);
            model.addAttribute("cart", cart);
            Float sum = 0.0f;
            for (Float val : cart.values()) {
                sum += val;
            }
            model.addAttribute("sum", sum);
        }
        return "/show_cart";
    }

    //show the cart
    @GetMapping("/user/show_cart")
    public String cart(HttpSession session, Model model) {
        Map<String, Float> cart = (Map<String, Float>) session.getAttribute("process");
        model.addAttribute("cart", cart);
        Float sum = 0.0f;
        for (Float val : cart.values()) {
            sum += val;
        }
        model.addAttribute("sum", sum);
        return "/show_cart";
    }

}
