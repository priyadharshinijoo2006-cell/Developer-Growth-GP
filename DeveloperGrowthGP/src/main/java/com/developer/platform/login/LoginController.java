package com.developer.platform.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.developer.platform.entity.User;
import com.developer.platform.service.UserService;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String login(@RequestBody User loginUser) {

        User user = userService.getUserByEmail(loginUser.getEmail());

        if (user == null) {
            return "Email not found";
        }

        if (user.getPassword().equals(loginUser.getPassword())) {
            return "Login Success";
        } else {
            return "Invalid Password";
        }
    }
}
