package com.codegym.controller;

import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailController {
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("email",new Email());
        return "/home";
    }

    @PostMapping("/update")
    public String update(Email email, Model model){
        model.addAttribute("email", email);
        return "/email";
    }
}
