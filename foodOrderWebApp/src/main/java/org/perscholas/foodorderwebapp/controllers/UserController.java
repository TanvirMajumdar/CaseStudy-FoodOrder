package org.perscholas.foodorderwebapp.controllers;

import org.perscholas.foodorderwebapp.dao.RoleRepo;
import org.perscholas.foodorderwebapp.dao.UserRepo;
import org.perscholas.foodorderwebapp.models.Role;
import org.perscholas.foodorderwebapp.models.User;
import org.perscholas.foodorderwebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping("/signup")
    public String signup(Model model){
        List<Role> listRoles=roleRepo.findAll();
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user){
        userService.save(user);
        return "registration_success";
    }


    @GetMapping("/userlist")
    public String showUserList(Model model){
        List<User> userList=userRepo.findAll();
        model.addAttribute("userList", userList);
        return "userlist";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") long id) {
        userService.deleteUser(id);
        return "redirect:/userlist";
    }

}
