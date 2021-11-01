package com.bzah.RestaurantWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.bzah.RestaurantWebApp.RestaurantWebAppApplication.*;

/**
 * Represents an array of items.
 *
 * @author Bilal Zahory
 * @author www.bzah.bz
 */

@Controller
public class OrderController {
// Deprecated in favor of global methods
//    public String controlMapping2(
//            @ModelAttribute("menu") final Model model) {
//        model.addAttribute("menu");
//        return "order";
//    }

    /**
     * Handles HTTP GET requests for the /admin page.
     *
     * @param model Contains attributes visible to Thymeleaf.
     * @return The current page.
     */
    @GetMapping("/order")
    public String orderForm(Model model) {
        model.addAttribute(menu);
        model.addAttribute("order", new Order());
        return "order";
    }

    /**
     * Processes form input for adding/searching for Orders.
     *
     * @param order The Order to be added.
     * @param model Contains attributes visible to Thymeleaf.
     * @return The current page.
     */
    @PostMapping("/order")
    public String orderSubmit(@ModelAttribute Order order, Model model) {
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

    /**
     * Handles HTTP GET requests for the /admin page.
     *
     * @param order The target Order.
     * @param model Contains attributes visible to Thymeleaf.
     * @return The current page.
     */
    @GetMapping("/searchOrders")
    public String searchOrderForm(@ModelAttribute Order order, Model model) {
        return "searchOrders";
    }


}