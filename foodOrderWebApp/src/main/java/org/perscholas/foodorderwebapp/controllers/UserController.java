package org.perscholas.foodorderwebapp.controllers;

import org.perscholas.foodorderwebapp.dao.RoleRepo;
import org.perscholas.foodorderwebapp.dao.UserRepo;
import org.perscholas.foodorderwebapp.models.Role;
import org.perscholas.foodorderwebapp.models.User;
import org.perscholas.foodorderwebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepo roleRepo;


    //user sign up
    @GetMapping("/signup")
    public String signup(Model model){
        List<Role> listRoles=roleRepo.findAll();
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("user", new User());
        return "signup";
    }


    //new user registration
    @PostMapping("/process_register")
    public ModelAndView processRegistration(@Valid User user, BindingResult bindingResult){
        ModelAndView model = new ModelAndView();
        if (bindingResult.hasErrors()) {
            model.setViewName("signup");
        }
        else {

            userService.saveUser(user);
            model.addObject("user", new User());
            model.setViewName("registration_success");
        }
        return model;
    }


    //to show the user list
    @GetMapping("/userlist")
    public String showUserList(Model model){
        List<User> userList=userRepo.findAll();
        model.addAttribute("userList", userList);
        return "userlist";
    }

    //to delete any user from the user list
    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") long id) {
        userService.deleteUser(id);
        return "redirect:/userlist";
    }

}
