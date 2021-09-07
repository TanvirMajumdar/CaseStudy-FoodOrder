package org.perscholas.foodorderwebapp;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.foodorderwebapp.dao.ItemRepo;
import org.perscholas.foodorderwebapp.dao.RoleRepo;
import org.perscholas.foodorderwebapp.dao.UserRepo;
import org.perscholas.foodorderwebapp.models.Item;
import org.perscholas.foodorderwebapp.models.Role;
import org.perscholas.foodorderwebapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Slf4j
@Component
@Log
@Transactional
public class AppStartupRunner implements CommandLineRunner {

    UserRepo userRepo;
    RoleRepo roleRepo;
    ItemRepo itemRepo;

    @Autowired
    public AppStartupRunner(UserRepo userRepo, RoleRepo roleRepo, ItemRepo foodItemRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.itemRepo=foodItemRepo;
    }

    @Override
    public void run(String... args) throws Exception {

//        log.info("**** Start adding sql statements ****");
//
//        roleRepo.save(new Role("ADMIN"));
//        roleRepo.save(new Role("USER"));
//
//        User user=new User();
//        Role userRole = roleRepo.findByRole("ADMIN");
//        user.setUsername("user21");
//        user.setPassword("codejava");
//        user.setPassword("$2a$09$VU9BvQZkoDjze4gPZStb2euI9Elvni5WYOGuQ8QactMXLOL.kk28.");
//        user.setFirstName("tanvir");
//        user.setLastName("majumdar");
//        user.setEmail("tanvir@yahoo.com");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//        userRepo.save(user);
//
//
//        itemRepo.save(new Item("Burger", "Hot and Spicy Burger", 2.99f));
//        itemRepo.save(new Item("Sandwich", "Sliced bread egg sandwich", 1.99f));
//        itemRepo.save(new Item("French Fries", "Long and thin fries", 0.99f));
//        log.info("**** End of sql statements ****");
//

    }

}

