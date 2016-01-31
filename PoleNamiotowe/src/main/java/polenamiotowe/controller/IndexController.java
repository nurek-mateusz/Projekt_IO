package polenamiotowe.controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import repositories.*;

@Controller
public class IndexController {

    UzytkownikRepository uzytkownikRespository;
    
    public IndexController(){
        uzytkownikRespository = new UzytkownikRepository();
    }

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

    @RequestMapping(value = "/rejestracja", method = RequestMethod.GET)
    public ModelAndView rejestracjaGet(Model model, @RequestParam(value = "pwd", required = false) String pwd, @RequestParam(value = "usr", required = false) String usr) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("rejestracja");

        try {
            if (!(pwd == null && usr == null)) {
                if (uzytkownikRespository.UzytkownikIstnieje(usr, pwd)) {
                    mav.addObject("blad", 1);
                } else {
                    uzytkownikRespository.RejestrujUzytkownika(usr, pwd);
                }

                return mav;
            }
        } catch (SQLException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mav;
    }

    @RequestMapping(value = "/rejestracja", method = RequestMethod.POST)
    public ModelAndView rejestracjaPost(Model model, @RequestParam(value = "pwd", required = false) String pwd) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("rejestracja");
        return mav;
    }

    @RequestMapping(value = "/rezerwacjaMiejsca", method = RequestMethod.GET)
    public ModelAndView rezerwacjaMiejscaGet(Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("RezerwacjaMiejsca");
        return mav;
    }

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public ModelAndView listaGet(Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("lista");
        return mav;
    }
}
