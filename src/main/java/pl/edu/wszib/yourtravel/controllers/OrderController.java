package pl.edu.wszib.yourtravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.yourtravel.model.Order;
import pl.edu.wszib.yourtravel.model.OrderPositions;
import pl.edu.wszib.yourtravel.model.Tour;
import pl.edu.wszib.yourtravel.model.User;
import pl.edu.wszib.yourtravel.model.view.TourModel;
import pl.edu.wszib.yourtravel.services.IBasketService;
import pl.edu.wszib.yourtravel.services.IOrderService;
import pl.edu.wszib.yourtravel.services.ITourService;
import pl.edu.wszib.yourtravel.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    ITourService tourService;

    @Autowired
    IBasketService basketService;

    @Autowired
    IOrderService orderService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String showOrder(Model model) {
        if (!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        User user = this.sessionObject.getLoggedUser();
        model.addAttribute("orders", this.orderService.getAllOrdersByUser(user));
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("info", this.sessionObject.getInfo());
        return "order";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String makeOrder(@ModelAttribute Order order, @ModelAttribute OrderPositions orderPositions) {
        if (!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        if (this.orderService.saveOrder(order) && (this.orderService.saveOrderPosition(orderPositions))){
            return "redirect:/main";
        }else {
            this.sessionObject.setInfo("Błąd zamówienia");
            return "redirect:/order";
        }
    }
}

