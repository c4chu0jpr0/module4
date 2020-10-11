package controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/index")
    public String showForm(){
        return "index";
    }
    @GetMapping("/calculate")
    public String calculate(Model model, @RequestParam float vnd){

        float usd = vnd/23000;
        model.addAttribute("usd", usd);
        return "index";
    }

}
