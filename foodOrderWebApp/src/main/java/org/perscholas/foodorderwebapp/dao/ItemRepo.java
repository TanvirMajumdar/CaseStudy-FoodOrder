package org.perscholas.foodorderwebapp.dao;

import org.perscholas.foodorderwebapp.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
}
