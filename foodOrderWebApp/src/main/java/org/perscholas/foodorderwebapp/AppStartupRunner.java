package org.perscholas.foodorderwebapp;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.foodorderwebapp.dao.FoodItemRepo;
import org.perscholas.foodorderwebapp.dao.RoleRepo;
import org.perscholas.foodorderwebapp.dao.UserRepo;
import org.perscholas.foodorderwebapp.models.FoodItem;
import org.perscholas.foodorderwebapp.models.Role;
import org.perscholas.foodorderwebapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
        roleRepo.save(new Role(2, "Customer"));
        log.info("**** End of sql statements ****");


        log.info("**** Start adding sql statements ****");
        userRepo.save(new User("tanvirahmed", "tanvir21", "tanvir", "majumdar", "tanvir@yahoo.com", "999-999-9999"));
        userRepo.save(new User("samiaahmed", "samia90", "samia", "akhter", "samia@yahoo.com", "111-111-1111"));
        log.info("**** End of sql statements ****");


        log.info("**** Start adding sql statements ****");
        foodItemRepo.save(new FoodItem("Burger", "Hot and Spicy Burger", 4.99f));
        foodItemRepo.save(new FoodItem("Sandwich", "Sliced bread egg sandwich", 3.99f));
        log.info("**** End of sql statements ****");
    }

}

