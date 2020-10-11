package com.codegym.controller;

import com.codegym.model.Calculate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String showForm(){
        return "home";
    }

    @PostMapping("/caculator")
    public String caculator(@RequestParam float num1, @RequestParam float num2, @RequestParam char operator, Model model){
        try{
            float result = Calculate.calculate(num1,num2,operator);
            model.addAttribute("result",result);
        }catch (Exception e){
            System.out.println("alo");
        }
        return "home";
    }
}
