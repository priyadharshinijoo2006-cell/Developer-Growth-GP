package com.developer.platform.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.developer.platform.entity.User;
import com.developer.platform.service.UserService;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    // Register page open
    @GetMapping("/register")
    public String showRegisterPage(Model model) {

        model.addAttribute("user", new User());

        return "register";
    }

    // Register form submit
    @PostMapping("/register")
    public String registerUser(User user, Model model) {

        try {
            userService.registerUser(user);

            return "redirect:/login?registered=true";

        } catch (RuntimeException e) {

            model.addAttribute("error", e.getMessage());
            model.addAttribute("user", user);

            return "register";
        }
    }
}
