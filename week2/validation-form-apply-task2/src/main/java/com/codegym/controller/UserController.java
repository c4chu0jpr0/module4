package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("users")
public class UserController {
    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("user",new User());
        return "list";
    }
    @PostMapping("")
    public String checkValidation(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        new User().validate(user.getNumber(),bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "list";
        }else {
            return "result";
        }
    }
}
