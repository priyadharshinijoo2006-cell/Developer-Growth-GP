package com.developer.platform.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.developer.platform.entity.User;
import com.developer.platform.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    // Open Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // Login Form Submit
    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            Model model) {

        User user = userService.loginUser(email, password);

        if (user != null) {
            model.addAttribute("user", user);
            return "dashboard";
        } else {
            model.addAttribute("error", "Invalid Email or Password");
            return "login";
        }
    }
}
