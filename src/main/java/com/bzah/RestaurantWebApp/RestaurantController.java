package com.bzah.RestaurantWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;


@SessionAttributes("menu")
@Controller
public class RestaurantController {

    Menu menu = new Menu();
    ArrayList<Order> orders = new ArrayList<>();

    @GetMapping("/admin")
    public String orderForm(Model model) {
        if(orders.size()>0)
        System.out.println("yes");
        else
            System.out.println("no");
        model.addAttribute("menu", menu);
        model.addAttribute("nextItem", new Item());
        return "admin";
    }

    @PostMapping("/admin")
    public String orderSubmit(@ModelAttribute Menu menu, @ModelAttribute Item nextItem, Model model) {
        menu.getMenu().put(nextItem.getName(), nextItem);
        model.addAttribute("nextItem", new Item());
        return "admin";
    }

    @RequestMapping(value = { "/mapping1" }, method = RequestMethod.POST)
    public String controlMapping1(
            @ModelAttribute("menu") final Menu menu,
            final BindingResult mapping1BindingResult,
            final Model model,
            final RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("menu", menu);

        return "redirect:mapping2";
    }

}