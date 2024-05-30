package com.example.usermanagement.Controller;


import com.example.usermanagement.Entity.ProductInsert;
import com.example.usermanagement.Exception.UserNotFoundException;
import com.example.usermanagement.Service.IUserManagementService;
import com.example.usermanagement.Service.IUserService;
import com.example.usermanagement.form.ProductForm;
import com.example.usermanagement.form.UserForm;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserManagementController {
    @Autowired
    private HttpSession session;
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
    @GetMapping("/detail")
    public String index3(Model model){
        model.addAttribute("detail",iUserManagementService.findAll());
        return"detail";
    }
    @PostMapping("/index")
    public String login(@Validated @ModelAttribute("loginForm") UserForm userForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "index";
        }else {
            try {
                session.setAttribute("user",iUserService.findByInfo(userForm.getLoginId(),userForm.getPassword()));
                return "redirect:/menu";
            } catch (UserNotFoundException e) {
                System.out.println("catch");
                return "index";
            }
        }
    }
    @PostMapping("/logout")
    public String logout(@ModelAttribute("loginForm") UserForm userForm) {
        session.invalidate();
        return "logout";
    }
    @GetMapping("/insert")
    public String index4(@ModelAttribute("ProductForm") ProductForm productForm) {
        return "insert";
    }

    @PostMapping("/insert")
    public String insert (@Validated @ModelAttribute("ProductForm") ProductForm productForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "/insert";
        }else {
            iUserManagementService.insert(new ProductInsert(productForm.getProduct_id(),productForm.getName(),productForm.getPrice(),productForm.getCategory_id(),productForm.getDescription()));

            return "redirect:/menu";
        }
    }
    @GetMapping("/search")
    public String search(@RequestParam(name="name")String name,Model model){
        model.addAttribute("products",iUserManagementService.findByName(name));
        return "menu";


    }








}
