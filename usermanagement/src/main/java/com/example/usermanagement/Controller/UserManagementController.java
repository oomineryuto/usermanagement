package com.example.usermanagement.Controller;

import com.example.usermanagement.form.UserForm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class UserManagementController {
    @GetMapping("/index")
    public String index(@ModelAttribute("loginForm") UserForm userform) {
        return "index";
    }
    @PostMapping("/index")

}
