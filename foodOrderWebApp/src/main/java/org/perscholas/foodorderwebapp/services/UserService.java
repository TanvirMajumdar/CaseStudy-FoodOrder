package org.perscholas.foodorderwebapp.services;

import org.perscholas.foodorderwebapp.dao.RoleRepo;
import org.perscholas.foodorderwebapp.dao.UserRepo;
import org.perscholas.foodorderwebapp.models.Role;
import org.perscholas.foodorderwebapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo,
                       RoleRepo roleRepo,
                       PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder=passwordEncoder;
    }

    private void encodePassword(User user){
        String encodePassword= passwordEncoder.encode((user.getPassword()));
        user.setPassword(encodePassword);
    }

    public List<User> listAll(){

        return (List<User>)userRepo.findAll();
    }

    public List<Role> listRoles(){

        return (List<Role>)roleRepo.findAll();
    }

   public void saveUser(User user) {

        Role userRole = roleRepo.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        encodePassword(user);
        userRepo.save(user);
    }
    public void deleteUser(long userId) {
        userRepo.deleteById(userId);
    }

}


