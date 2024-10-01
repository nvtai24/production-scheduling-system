package org.nvtai.production_scheduling_system.controller.auth;

import org.nvtai.production_scheduling_system.model.UserModel;
import org.nvtai.production_scheduling_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/mylogin")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid username or password");
        }
        return "html/login"; // Đảm bảo rằng đường dẫn đến trang login là chính xác
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