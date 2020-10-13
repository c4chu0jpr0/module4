package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.CustomerService.CustomerService;
import com.codegym.service.ProvinceService.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String showList(Model model){
        Iterable<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces",provinces);
        return "/province/list";
    }
    @GetMapping("/create-province")
    public String showFormCreate(Model model){
        model.addAttribute("province",new Province());
        return "/province/create";
    }
    @PostMapping("/create-province")
    public String createProvince(@ModelAttribute("province") Province province, Model model){
        provinceService.save(province);
        model.addAttribute("message","New province created successfully");
        return "/province/create";
    }
    @GetMapping("/edit-province/{id}")
    public String showFormEdit(Model model, @PathVariable Long id){
        model.addAttribute("province",provinceService.findById(id));
        return "/province/edit";
    }
    @PostMapping("/edit-province/{id}")
    public String editProvince(@ModelAttribute("province") Province province, Model model){
        provinceService.save(province);
        model.addAttribute("message","Province updated successfully");
        return "/province/edit";
    }
    @GetMapping("/delete-province/{id}")
    public String showFormDelete(Model model, @PathVariable Long id){
        model.addAttribute("province",provinceService.findById(id));
        return "/province/delete";
    }
    @PostMapping("/delete-province/{id}")
    public String deleteProvince(Model model, @ModelAttribute Province province){
        provinceService.remove(province.getId());
        model.addAttribute("message","xóa thành công! " );
        return "/province/delete";
    }
    @GetMapping("/detail-province/{id}")
    public String showFormDetail(@PathVariable("id") Long id,Model model){
        Province province = provinceService.findById(id);
        Iterable<Customer> customers = customerService.findAllByProvince(province);
        model.addAttribute("province",province);
        model.addAttribute("customers",customers);
        return "/province/detail";
    }
}
