package com.bzah.RestaurantWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.bzah.RestaurantWebApp.RestaurantWebAppApplication.*;


@Controller
public class OrderController {

//    public String controlMapping2(
//            @ModelAttribute("menu") final Model model) {
//        model.addAttribute("menu");
//        return "order";
//    }

    @GetMapping("/order")
    public String orderForm(Model model) {
        model.addAttribute(menu);
        model.addAttribute("order", new Order());
        return "order";
    }

    @PostMapping("/order")
    public String orderSubmit(@ModelAttribute Menu menu, @ModelAttribute Order order, Model model) {
        if (!orders.containsOrderNumber(order.getOrderNumber())) {
            model.addAttribute("order", order);
            order.processString(menu);
            orders.add(order);
            return "searchOrders";
        } else {
            model.addAttribute("order", orders.getOrderByNumber(order.getOrderNumber()));
            return "searchOrders";
        }
    }

    @GetMapping("/searchOrders")
    public String searchOrderForm(@ModelAttribute Order order, Model model) {
        return "searchOrders";
    }

    @PostMapping("/searchOrder")
    public String searchOrderSubmit(@ModelAttribute Menu menu, @ModelAttribute Order order, Model model) {
        return "searchOrders" + order.getOrderNumber();
    }

}