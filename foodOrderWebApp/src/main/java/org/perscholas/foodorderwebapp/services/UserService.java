package org.perscholas.foodorderwebapp.services;

import org.perscholas.foodorderwebapp.dao.RoleRepo;
import org.perscholas.foodorderwebapp.dao.UserRepo;
import org.perscholas.foodorderwebapp.models.Role;
import org.perscholas.foodorderwebapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;

@Service
@Transactional
public class UserService {

    private UserRepo userRepo;
    private RoleRepo roleRepo;

    @Autowired
    public UserService(UserRepo userRepo,
                       RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

   public void saveUser(User user) {
        Role userRole = roleRepo.findByRole("Customer");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepo.save(user);
    }
    public void deleteUser(long userId) {
        userRepo.deleteById(userId);
    }

}


