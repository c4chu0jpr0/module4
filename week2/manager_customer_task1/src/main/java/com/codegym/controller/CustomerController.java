package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> list = customerService.findAll();
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView addCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        return new ModelAndView("redirect:" +"/customers");
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String formDelete(@PathVariable Long id){
        customerService.remove(id);
        return "redirect:/customers";
    }
}
