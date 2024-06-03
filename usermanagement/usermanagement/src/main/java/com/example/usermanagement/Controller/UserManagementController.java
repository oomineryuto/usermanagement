package com.example.usermanagement.Controller;


import com.example.usermanagement.Entity.ProductInsert;
import com.example.usermanagement.Entity.ProductRecord;
import com.example.usermanagement.Entity.ProductUpdate;
import com.example.usermanagement.Exception.UserNotFoundException;
import com.example.usermanagement.Service.IUserManagementService;
import com.example.usermanagement.Service.IUserService;
import com.example.usermanagement.form.ProductForm;
import com.example.usermanagement.form.UpdateForm;
import com.example.usermanagement.form.UserForm;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/detail/{id}")
    public String index3(@PathVariable("id") int id, Model model){
        model.addAttribute("detail",iUserManagementService.findById(id));
        return "/detail";
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

            return "redirect:/insert";

        }
    }
    @GetMapping("/search")
    public String search(@RequestParam(name="name")String name,Model model){
        model.addAttribute("products",iUserManagementService.findByName(name));
        return "menu";
    }

    @PostMapping("/detail/{id}")
    public String delete(@PathVariable("id") int id){
        iUserManagementService.findById(id);
        iUserManagementService.delete(id);
        return "redirect:/menu";
    }
    @GetMapping("/updateInput/{id}")
    public String index2(@ModelAttribute("ProductForm") ProductForm productForm,@PathVariable("id") int id,Model model) {
        model.addAttribute("product",iUserManagementService.findById(id));
        return "updateInput";
    }
    @PostMapping("/updateInput/{id}")
    public String update (@PathVariable("id") int id, @Validated @ModelAttribute("UpdateForm") UpdateForm updateForm, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()) {
            model.addAttribute("product",iUserManagementService.findById(id));
            return "updateInput";
        }else {
            System.out.println(id);
            System.out.println(updateForm.getName());
            System.out.println(updateForm.getProduct_id());
            System.out.println(updateForm.getPrice());
            System.out.println(updateForm.getDescription());
            iUserManagementService.update(new ProductUpdate(
                    id,updateForm.getProduct_id(),updateForm.getName(),updateForm.getPrice(),updateForm.getCategory_id(),updateForm.getDescription()));

            return "redirect:/menu";
        }
    }





}
