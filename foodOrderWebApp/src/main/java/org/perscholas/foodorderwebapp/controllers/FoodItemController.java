package org.perscholas.foodorderwebapp.controllers;

import org.perscholas.foodorderwebapp.models.FoodItem;
import org.perscholas.foodorderwebapp.services.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FoodItemController {

    @Autowired
    FoodItemService foodItemService;

    @RequestMapping("/newfooditem")
    public String showNewFoodItem(Model model) {
        FoodItem foodItem = new FoodItem();
        model.addAttribute("foodItem", foodItem);

        return "newfooditem";
    }

    @RequestMapping(value = "/new_food_added", method = RequestMethod.POST)
    public String saveFoodItem(@ModelAttribute("foodItem") FoodItem foodItem) {
        foodItemService.saveFoodItem(foodItem);

        return "new_food_added";
    }

    @RequestMapping("/fooditemlist")
    public String viewFoodItem(Model model) {
        List<FoodItem> foodItems = foodItemService.listAll();
        model.addAttribute("foodItems", foodItems);

        return "fooditemlist";
    }

    @GetMapping("/updateFoodItem/{id}")
    public String updateFoodItem(@PathVariable(value = "id") long id, Model model) {
        FoodItem foodItem=foodItemService.getFoodItemById(id);
        model.addAttribute("foodItem", foodItem);
        return "updateFoodItem";
    }

    @GetMapping("/deleteFoodItem/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id) {

        this.foodItemService.deleteFoodItemById(id);
        return "redirect:/fooditemlist";
    }

}
