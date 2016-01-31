/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.sun.faces.action.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

/**
 *
 * @author Mateusz Purgał
 */
@Controller
@RequestMapping("/hello")
public class HelloController{

   @RequestMapping(value="/dupa")
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");
      return "hello";
   }

}