package polenamiotowe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
    
    @RequestMapping("/kontakt")
    public String kontakt(Model model) {
        return "kontakt";
    }
    
    @RequestMapping("/rejestracja")
    public String rejestracja(Model model) {
    	return "rejestracja";
    }
    
    @RequestMapping("/login") 
    public String login(Model model) {
    	return "login";
    }
}
