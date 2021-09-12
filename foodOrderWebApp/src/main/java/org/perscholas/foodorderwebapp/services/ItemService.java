package org.perscholas.foodorderwebapp.services;

import org.perscholas.foodorderwebapp.dao.ItemRepo;
import org.perscholas.foodorderwebapp.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService {

    @Autowired
    private ItemRepo itemRepo;

    public List<Item> listAll(){
        return itemRepo.findAll();
    }

    public void saveItem(Item foodItem){
        itemRepo.save(foodItem);
    }

    public Item getItemById(long itemId) {
        Optional<Item> optional = itemRepo.findById(itemId);
        Item foodItem = null;
        if (optional.isPresent()) {
            foodItem = optional.get();
        } else {
            throw new RuntimeException(" Food Item not found for id :: " + itemId);
        }
        return foodItem;
    }

    public void deleteItemById(long itemId) {
        this.itemRepo.deleteById(itemId);
    }

    public Optional<Item> findById(Long id) {
        return itemRepo.findById(id);
    }


}
