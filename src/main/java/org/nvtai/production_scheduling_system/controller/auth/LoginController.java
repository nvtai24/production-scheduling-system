package org.nvtai.production_scheduling_system.controller.auth;

import org.nvtai.production_scheduling_system.model.UserModel;
import org.nvtai.production_scheduling_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String login() {
        return "html/login";
    }


    @PostMapping("/user/authenticate")
    public String authenticate(@RequestParam String username, @RequestParam String password, Model model) {
        UserModel userModel = userService.authenticate(username, password);
        if (userModel != null) {
            model.addAttribute("user", userModel); // Truyền userModel vào model
            return "html/home";
        }
        model.addAttribute("error", "Invalid username or password");
        return "html/login";
    }


}