package org.perscholas.foodorderwebapp;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.foodorderwebapp.dao.FoodItemRepo;
import org.perscholas.foodorderwebapp.dao.RoleRepo;
import org.perscholas.foodorderwebapp.dao.UserRepo;
import org.perscholas.foodorderwebapp.models.FoodItem;
import org.perscholas.foodorderwebapp.models.Role;
import org.perscholas.foodorderwebapp.models.User;
import org.perscholas.foodorderwebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
@Log
@Transactional
public class AppStartupRunner implements CommandLineRunner {

    UserRepo userRepo;
    RoleRepo roleRepo;
    FoodItemRepo foodItemRepo;

    @Autowired
    public AppStartupRunner(UserRepo userRepo, RoleRepo roleRepo, FoodItemRepo foodItemRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.foodItemRepo=foodItemRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("**** Start adding sql statements ****");
        roleRepo.save(new Role(1, "Admin"));


        User user=new User();
        Role userRole = roleRepo.findByRole("Admin");
        user.setUsername("tanvir");
        user.setPassword("tanvir21");
        user.setFirstName("tanvir");
        user.setLastName("majumdar");
        user.setEmail("tanvir@yahoo.com");
        user.setPhone("999-999-9999");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepo.save(user);


        foodItemRepo.save(new FoodItem("Burger", "Hot and Spicy Burger", 4.99f));
        foodItemRepo.save(new FoodItem("Sandwich", "Sliced bread egg sandwich", 3.99f));
        log.info("**** End of sql statements ****");
    }

}

