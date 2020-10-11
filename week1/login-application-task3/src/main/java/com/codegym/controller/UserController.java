package com.codegym.controller;

import com.codegym.model.Login;
import com.codegym.model.User;
import com.codegym.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("login",new Login());
        return "/home";
    }
    @PostMapping("/login")
    public String login(Login login, Model model){
        User user = UserService.checkLogin(login);
       if(user ==null){
           model.addAttribute("message","sai dang nhap");
           return "redirect:/home";
       }else {
           model.addAttribute("user",user);
           return "/user";
       }
    }
}
