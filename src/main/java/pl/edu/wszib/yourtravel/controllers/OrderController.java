package pl.edu.wszib.yourtravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.yourtravel.model.Order;
import pl.edu.wszib.yourtravel.model.Tour;
import pl.edu.wszib.yourtravel.services.IOrderService;
import pl.edu.wszib.yourtravel.services.ITourService;
import pl.edu.wszib.yourtravel.session.SessionObject;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    ITourService tourService;

    @Autowired
    IOrderService orderService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String showOrder(Model model) {
        if (!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        model.addAttribute("orders", this.orderService.getAllOrders());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("info", this.sessionObject.getInfo());

        Order order = new Order();
        this.orderService.saveOrder(order);
        return "order";
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String makeOrder(@PathVariable int id) {
        if (!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        Order order = this.orderService.getOrderById(id);
        System.out.println(order);
        return "redirect:/order";
    }

}

