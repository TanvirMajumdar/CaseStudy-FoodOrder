package org.perscholas.foodorderwebapp.controllers;

import org.perscholas.foodorderwebapp.models.FoodItem;
import org.perscholas.foodorderwebapp.services.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FoodItemController {

    @Autowired
    FoodItemService foodItemService;

    //adding new food item
    @RequestMapping("/newfooditem")
    public String showNewFoodItem(Model model) {
        FoodItem foodItem = new FoodItem();
        model.addAttribute("foodItem", foodItem);

        return "newfooditem";
    }

    //confirming new food item is being added
    @RequestMapping(value = "/new_food_added", method = RequestMethod.POST)
    public String saveFoodItem(@ModelAttribute("foodItem") FoodItem foodItem) {
        foodItemService.saveFoodItem(foodItem);

        return "new_food_added";
    }

    //to show food item list to the admin
    @RequestMapping("/fooditemlist")
    public String viewFoodItem(Model model) {
        List<FoodItem> foodItems = foodItemService.listAll();
        model.addAttribute("foodItems", foodItems);

        return "fooditemlist";
    }

    //to update any food item on the list
    @GetMapping("/updateFoodItem/{id}")
    public String updateFoodItem(@PathVariable(value = "id") long id, Model model) {
        FoodItem foodItem=foodItemService.getFoodItemById(id);
        model.addAttribute("foodItem", foodItem);
        return "updateFoodItem";
    }

    //to delete any food item on the list
    @GetMapping("/deleteFoodItem/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id) {

        this.foodItemService.deleteFoodItemById(id);
        return "redirect:/fooditemlist";
    }

    //to show food item list to the customer
    @GetMapping("/menu")
    public String menu(Model model){
        List<FoodItem> foodItems = foodItemService.listAll();
        model.addAttribute("foodItems", foodItems);

        return "menu";
    }

    //add food item to the cart
    @RequestMapping("/addToCart/{id}")
    public String addToCart(@PathVariable (value = "id") Long id, Model model, HttpSession session) {

        FoodItem item = foodItemService.getFoodItemById(id);
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
        return "show_cart";
    }

    //show the cart
    @RequestMapping("/show_cart")
    public String cart(HttpSession session, Model model) {
        Map<String, Float> cart = (Map<String, Float>) session.getAttribute("process");
        model.addAttribute("cart", cart);
        Float sum = 0.0f;
        for (Float val : cart.values()) {
            sum += val;
        }
        model.addAttribute("sum", sum);
        return "show_cart";
    }

}
