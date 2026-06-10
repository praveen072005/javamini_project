package com.example.jewel.jewelcontroller;

import com.example.jewel.jewelmodel.User;
import com.example.jewel.jewelservices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserControl {
    @Autowired
    private UserService userService;

    // Signup with JSON
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            return "Invalid JSON: username or password missing";
        }
        return userService.signup(user) ? "Signup Successful" : "Signup Failed";
    }

    // ✅ Signin also with JSON body (not query params)
    @PostMapping("/signin")
    public String signin(@RequestBody User user) {
        boolean result = userService.signin(user.getUsername(), user.getPassword());
        return result ? "Signin successful" : "Invalid username or password";
    }
}
