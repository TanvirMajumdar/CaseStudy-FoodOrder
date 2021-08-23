package org.perscholas.foodorderwebapp.dao;

import org.perscholas.foodorderwebapp.models.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Long> {
}
