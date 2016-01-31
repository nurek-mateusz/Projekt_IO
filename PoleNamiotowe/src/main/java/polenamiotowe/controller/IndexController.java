package polenamiotowe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class IndexController {
    
    
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
    
    @RequestMapping("/kontakt")
    public ModelAndView kontakt(Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("kontakt");
        mav.addObject("parametr", 5);
        return mav;
    }
    
    @RequestMapping(value = "/rejestracja", method=RequestMethod.GET)
        public ModelAndView rejestracjaGet(Model model, @RequestParam(value="pwd",required=false) String pwd) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("rejestracja");
        return mav;
    }
    
    
    @RequestMapping(value = "/rezerwacjaMiejsca", method=RequestMethod.GET)
    public ModelAndView rezerwacjaMiejscaGet(Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("RezerwacjaMiejsca");
        return mav;
    }
        @RequestMapping(value = "/lista", method=RequestMethod.GET)
    public ModelAndView listaGet(Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("lista");
        return mav;
    }
}
