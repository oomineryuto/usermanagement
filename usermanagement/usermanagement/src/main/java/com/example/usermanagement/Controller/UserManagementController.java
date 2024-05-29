package com.example.usermanagement.Controller;


import com.example.usermanagement.Exception.UserNotFoundException;
import com.example.usermanagement.Service.IUserManagementService;
import com.example.usermanagement.Service.IUserService;
import com.example.usermanagement.form.UserForm;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class UserManagementController {
    @Autowired
    IUserService iUserService;
    @Autowired
    IUserManagementService iUserManagementService;
    @GetMapping("/index")
    public String index(@ModelAttribute("loginForm") UserForm userform) {
        return "index";
    }
    @GetMapping("/menu")
    public String index2(Model model){
        model.addAttribute("products",iUserManagementService.findAll());
        return "menu";
    }
    @PostMapping("/index")
    public String login(@Validated @ModelAttribute("loginForm") UserForm userForm, BindingResult bindingResult, Model model) {
        System.out.println(userForm);
//        model.addAttribute("userform",iUserService.findByInfo(userForm.getLoginId(),userForm.getPassword()));
        if(bindingResult.hasErrors()) {
            return "index";
        }else {
            try {
//                model.addAttribute("loginForm", iUserService.findByInfo(userForm.getLoginId(), userForm.getPassword()));
                System.out.println(iUserService.findByInfo(userForm.getLoginId(),userForm.getPassword()));
                return "redirect:/menu";
            } catch (UserNotFoundException e) {
                System.out.println("catch");
                return "index";
            }
        }
    }
}
