package org.nvtai.production_scheduling_system.controller;

import org.nvtai.production_scheduling_system.model.UserModel;
import org.nvtai.production_scheduling_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String login() {
        return "html/login";
    }

    @PostMapping("user/authenticate")
    public String authenticate(@RequestParam String username, @RequestParam String password, Model model) {
        UserModel userModel = userService.authenticate(username, password);
        if (userModel != null) {
            // Add user information to the model to display in the view
            model.addAttribute("user", userModel);
            return "html/home";
        }
        model.addAttribute("error", "Invalid username or password");
        return "html/login";  // Redirect back to the login page with error message
    }

}