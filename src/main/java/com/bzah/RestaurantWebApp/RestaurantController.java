package com.bzah.RestaurantWebApp;

import org.springframework.boot.system.JavaVersion;
import org.springframework.boot.system.SystemProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.*;
import java.util.ArrayList;

import static com.bzah.RestaurantWebApp.RestaurantWebAppApplication.*;


@Controller
public class RestaurantController {

    @GetMapping("/admin")
    public String adminForm(Model model) {
        model.addAttribute("menu", menu);
        model.addAttribute("nextItem", new Item());
        return "admin";
    }

    @PostMapping("/admin")
    public String orderSubmit(@ModelAttribute Item nextItem, Model model) {
        menu.getMenu().put(nextItem.getName(), nextItem);
        model.addAttribute("nextItem", new Item());
        return "redirect:admin";
    }

    @GetMapping("manageOrders")
    public String orders(Model model) {
        model.addAttribute("orders", orders);
        return "manageOrders";
    }

    @PostMapping("/manageOrders")
    public String removeOrder(@RequestParam(value = "input1", defaultValue = "-1") String input1,
                              @RequestParam(value = "input2", defaultValue = "-1") String input2, Model model) {
        Long index1 = new Long(input1.trim());
        orders.removeOrder(index1);

        Long index2 = new Long(input2.trim());
        orders.markOrderAsReady(index2);


        return "redirect:manageOrders";
    }

//    @RequestMapping(value = { "/mapping1" }, method = RequestMethod.POST)
//    public String controlMapping1(
//            @ModelAttribute("menu") final Menu menu,
//            final BindingResult mapping1BindingResult,
//            final Model model,
//            final RedirectAttributes redirectAttributes) {
//
//        redirectAttributes.addFlashAttribute("menu", menu);
//
//        return "redirect:mapping2";
//    }

}