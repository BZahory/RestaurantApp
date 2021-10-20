package com.bzah.RestaurantWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLOutput;
import java.util.ArrayList;

@SessionAttributes({"orders","menu"})
@Controller
public class OrderController {

    public String controlMapping2(
            @ModelAttribute("menu") final Model model) {
        model.addAttribute("menu");
        return "order";
    }

    @GetMapping("/order")
    public String orderForm(@ModelAttribute Menu menu, Model model) {
        if(!model.containsAttribute("menu"))
            return "index";
        model.addAttribute(menu);
        model.addAttribute("order", new Order());
        return "order";
    }

    @PostMapping("/order")
    public String orderSubmit(@ModelAttribute Menu menu, @ModelAttribute Order order, Model model) {
        model.addAttribute("order", order);
        order.processString(menu);
        return "result";
    }

}