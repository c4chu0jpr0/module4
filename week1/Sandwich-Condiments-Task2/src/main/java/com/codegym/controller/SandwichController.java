package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @GetMapping("/home")
    public String get(){
        return "home";
    }

    @PostMapping("/save")
    public String save(@RequestParam String[] condiment, Model model){
        String result = "";
        for (String con: condiment){
            result += con +", ";
        }
        model.addAttribute("result",result);
        return "home";
    }
}
