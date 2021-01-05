package pl.edu.wszib.yourtravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.yourtravel.services.ITourService;
import pl.edu.wszib.yourtravel.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class CommonController {

    @Autowired
    ITourService tourService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landingPage(){
        return "redirect:/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model){
        model.addAttribute("tours", this.tourService.getAllTours());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        return "main";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactPage(Model model){
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "contact";
    }
}
