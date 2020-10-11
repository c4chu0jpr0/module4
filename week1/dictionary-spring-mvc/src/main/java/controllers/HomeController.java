package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/index")
    public String showForm(){
        return "index";
    }


    @GetMapping("/dictionary")
    public String dictionary(Model model, @RequestParam String word){
        String result;
        switch (word){
            case "hello":
                result="xin chào";
                break;
            default:
                result="Từ này tôi chưa thêm vào từ điển";
                break;
        }
        model.addAttribute("result",result);
        return "redirect:/index";
    }
}
