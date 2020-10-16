package com.codegym.controller;

import com.codegym.model.PhoneNumber;
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
@RequestMapping("/phone")
public class PhoneController {
    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("phonenumber", new PhoneNumber());
        return "list";
    }
    @PostMapping("")
    public String checkValidation(@Valid @ModelAttribute("phonenumber") PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
        new PhoneNumber().validate(phoneNumber,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "list";
        }else {
            model.addAttribute("phonenumber",phoneNumber.getNumber());
        return "result";
        }
    }
}