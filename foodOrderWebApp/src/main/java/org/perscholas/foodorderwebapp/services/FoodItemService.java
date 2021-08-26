package org.perscholas.foodorderwebapp.services;

import org.perscholas.foodorderwebapp.dao.FoodItemRepo;
import org.perscholas.foodorderwebapp.models.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FoodItemService {

    @Autowired
    private FoodItemRepo foodItemRepo;

    public List<FoodItem> listAll(){
        return foodItemRepo.findAll();
    }

    public void saveFoodItem(FoodItem foodItem){
        foodItemRepo.save(foodItem);
    }

    public void deleteFoodItem (long itemId) {
        foodItemRepo.deleteById(itemId);
    }

    public FoodItem getFoodItemById(long itemId) {
        Optional<FoodItem> optional = foodItemRepo.findById(itemId);
        FoodItem foodItem = null;
        if (optional.isPresent()) {
            foodItem = optional.get();
        } else {
            throw new RuntimeException(" Food Item not found for id :: " + itemId);
        }
        return foodItem;
    }

    public void deleteFoodItemById(long itemId) {
        this.foodItemRepo.deleteById(itemId);
    }


}
