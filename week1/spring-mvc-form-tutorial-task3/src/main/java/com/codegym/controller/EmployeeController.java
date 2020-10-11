package com.codegym.controller;

import com.codegym.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @RequestMapping("/showform")
    public String showForm(ModelMap model){
        model.addAttribute("employee",new Employee());
        return "/create";
    }
    @PostMapping("/create")
    public String submit(Employee employee,Model model){
        model.addAttribute("employee",employee);
        return "/info";
    }
}
