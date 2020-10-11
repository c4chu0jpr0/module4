package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.customers.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("list");
        Iterable<Customer> customers = customerService.findAll();
        modelAndView.addObject("list",customers);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView formCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        return new ModelAndView("redirect:" +"/customers");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView formEdit(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer",customerService.findById(id));
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView editCustomer(@ModelAttribute("customer") Customer customer){
        customerService.update(customer);
        return  new ModelAndView("redirect:" + "/customers");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteCustomer(@PathVariable Integer id){
        customerService.remove(id);
        return new ModelAndView("redirect:" +"/customers");
    }
}
