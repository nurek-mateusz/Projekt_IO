package polenamiotowe.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

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

    PoleRespository poleRespository;
    
    RezerwacjaRespository rezerwacjaRespository;

    public IndexController() {
        uzytkownikRespository = new UzytkownikRepository();
        poleRespository = new PoleRespository();
        rezerwacjaRespository = new RezerwacjaRespository();
    }

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/login")
    public ModelAndView login(Model model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        String user = request.getParameter("usr");
        String password = request.getParameter("pwd");
        
        try {
            String userId = uzytkownikRespository.WeryfikujLoginHaslo(user, password);
            if (userId != null) {
                HttpSession session = request.getSession();
                session.removeAttribute("userId");
                session.setAttribute("userId", userId);
                session.setMaxInactiveInterval(9000);
                mav.clear();
                mav.setViewName("lista");
                return mav;
            }
        } catch (SQLException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }

        mav.setViewName("index");
        mav.addObject("blad", "Niepoprawna nazwa u¿ytkownika lub has³o");
        return mav;
    }

    @RequestMapping("/kontakt")
    public ModelAndView kontakt(Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("kontakt");
        mav.addObject("parametr", 5);
        return mav;
    }

    @RequestMapping(value = "/rejestracja", method = RequestMethod.GET)
    public ModelAndView rejestracjaGet(Model model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("rejestracja");

        String user = request.getParameter("usr");
        String password = request.getParameter("pwd");

        try {

            if (!(password == null && user == null)) {
                if (uzytkownikRespository.UzytkownikIstnieje(user, password)) {
                    mav.addObject("blad", "U¿ytkownik jest ju¿ zajêty!!");

                } else {
                    uzytkownikRespository.RejestrujUzytkownika(user, password);
                    mav.setViewName("index");
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

    public ModelAndView rezerwacjaMiejscaGet(Model model, HttpServletRequest request, @RequestParam(value = "poleId", required = true) int poleID) throws SQLException {

        ModelAndView mav = new ModelAndView();

        HttpSession session = request.getSession();
        if (session.getAttribute("userId") == null) {
            mav.setViewName("index");
            return mav;
        }

        mav.setViewName("RezerwacjaMiejsca");

        List<KawalekPola> listaKawalkow = new ArrayList<KawalekPola>();
        try {
            listaKawalkow = poleRespository.pobierzKawalkiPola(poleID);
        } catch (SQLException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (listaKawalkow == null) {
            mav.addObject("Blad", "To pole nie ma ¿adnych kawa³ków!");
        } else {
            mav.addObject("ListaKawalkow", listaKawalkow);
        }
        return mav;
    }

    @RequestMapping(value = "/zarezerwujMiejsce", method = RequestMethod.GET)
    public ModelAndView zarezerwujMiejsceGet(Model model,HttpServletRequest request, @RequestParam(value = "idKawalka", required = true) int poleID,
            @RequestParam(value = "dataRozpoczecia", required = true) String dataRozpoczecia, @RequestParam(value = "dataZakonczenia", required = true) String dataZakonczenia) {
        ModelAndView mav = new ModelAndView("lista");

        
        HttpSession session = request.getSession();
        Integer userID = Integer.parseInt((String) session.getAttribute("userId"));
        try {
            if(rezerwacjaRespository.mozliwaRejestracja(dataRozpoczecia, dataZakonczenia, poleID))
            {
                    rezerwacjaRespository.dodajRezerwacje(dataRozpoczecia, dataZakonczenia, userID, poleID);
                    request.setAttribute("success", "Uda³o siê zarezerwowaæ miejsce!");
            }
            else{
               request.setAttribute("blad", "Na dany termin rezerwacja nie jest mo¿liwa");
            }
                
        } catch (ParseException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return mav;
    }

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public ModelAndView listaGet(Model model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        HttpSession session = request.getSession();
        if (session.getAttribute("userId") == null) {
            mav.setViewName("index");
            return mav;
        }

        mav.setViewName("lista");

        return mav;
    }

    @RequestMapping(value = "/dodawaniePola", method = RequestMethod.GET)

    public ModelAndView dodawaniePolaGet(Model model, HttpServletRequest request) throws SQLException {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("DodawaniePola");

        HttpSession session = request.getSession();
        if (session.getAttribute("userId") == null) {
            mav.setViewName("index");
            return mav;
        }

        String adres = request.getParameter("adres");
        String opis = request.getParameter("opis");
        Integer userID = Integer.parseInt((String) session.getAttribute("userId"));

        if (!(adres == null)) {

            if (poleRespository.istniejePole(adres)) {
                mav.addObject("blad", "Pole ju¿ istnieje!");
            } else {
                poleRespository.dodajPole(adres, opis, userID);
                mav.setViewName("lista");
            }

        }
        return mav;
    }

    @RequestMapping(value = "/DodawaniePola", method = RequestMethod.GET)
    public ModelAndView DodawaniePolaGet(Model model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        HttpSession session = request.getSession();
        if (session.getAttribute("userId") == null) {
            mav.setViewName("index");
            return mav;
        }
        mav.setViewName("DodawaniePola");

        return mav;
    }

    @RequestMapping(value = "/edycjaPola", method = RequestMethod.GET)
    public ModelAndView edycjaPolaGet(Model model, @RequestParam(value = "dane", required = false) String dane,
            @RequestParam(value = "poleId", required = true) int poleId) {
        
        if(dane!= null)
        {
            poleRespository.aktualizujPole(poleId, dane);
        }
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("edycjaPola");

        //HttpSession session = request.getSession();
        //if (session.getAttribute("userId") == null) {
        //    mav.setViewName("index");
        //    return mav;
        //}

        return mav;
    }

    @RequestMapping(value = "/ListaSwoichPol", method = RequestMethod.GET)
    public ModelAndView ListaSwoichPolGet(Model model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        HttpSession session = request.getSession();
        if (session.getAttribute("userId") == null) {
            mav.setViewName("index");
            return mav;
        }

        mav.setViewName("ListaSwoichPol");

        return mav;
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(Model model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        HttpSession session = request.getSession();
        session.invalidate();

        mav.setViewName("index");

        return mav;
    }

}
