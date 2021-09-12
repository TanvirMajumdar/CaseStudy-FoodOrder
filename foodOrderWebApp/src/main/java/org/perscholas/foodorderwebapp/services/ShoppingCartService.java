package org.perscholas.foodorderwebapp.services;

import org.perscholas.foodorderwebapp.dao.ItemRepo;
import org.perscholas.foodorderwebapp.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartService {

    private final ItemRepo itemRepo;

    private Map<Item, Integer> items = new HashMap<>();

    @Autowired
    public ShoppingCartService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public void addItem(Item item) {
        if (items.containsKey(item)) {
            items.replace(item, items.get(item) + 1);
        } else {
            items.put(item, 1);
        }
    }

    public void removeItem(Item item) {
        if (items.containsKey(item)) {
            if (items.get(item) > 1)
                items.replace(item, items.get(item) - 1);
            else if (items.get(item) == 1) {
                items.remove(item);
            }
        }
    }


    public Map<Item, Integer> getItemsInCart() {
        return Collections.unmodifiableMap(items);
    }


    public BigDecimal getTotal() {
        return items.entrySet().stream()
                .map(entry -> entry.getKey().getItemPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
