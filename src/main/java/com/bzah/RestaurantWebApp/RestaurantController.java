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
public class RestaurantController {

    /**
     * Handles HTTP GET requests for the /admin page.
     *
     * @param model Contains attributes visible to Thymeleaf.
     * @return The current page.
     */
    @GetMapping("/admin")
    public String menuForm(Model model) {
        model.addAttribute("menu", menu);
        model.addAttribute("nextItem", new Item());
        return "admin";
    }

    /**
     * Processes form input for new menu item.
     *
     * @param nextItem The Item that will be added.
     * @param model    Contains attributes visible to Thymeleaf.
     * @return The current page.
     */
    @PostMapping("/admin")
    public String menuSubmit(@ModelAttribute Item nextItem, Model model) {
        menu.getMenu().put(nextItem.getName(), nextItem); //Add the Item to the Menu
        model.addAttribute("nextItem", new Item());
        return "redirect:admin";
    }

    /**
     * Handles HTTP GET requests for the /manageOrders page.
     *
     * @param model Contains attributes visible to Thymeleaf.
     * @return The current page.
     */
    @GetMapping("manageOrders")
    public String orders(Model model) {
        model.addAttribute("orders", orders);
        return "manageOrders";
    }

    /**
     * Processes form input for marking Orders as ready and for removal
     *
     * @param input1 The order number of the Order to be removed, defaults to -1.
     * @param input2 The order number of the Order to be marked as ready, defaults to -1.
     * @param model  Contains attributes visible to Thymeleaf.
     * @return A redirect to the current page.
     */
    @PostMapping("/manageOrders")
    public String handleOrders(@RequestParam(value = "input1", defaultValue = "-1") String input1,
                               @RequestParam(value = "input2", defaultValue = "-1") String input2, Model model) {
        Long index1 = new Long(input1.trim());
        orders.removeOrderByNumber(index1);

        Long index2 = new Long(input2.trim());
        orders.markOrderAsReady(index2);


        return "redirect:manageOrders";
    }

// Deprecated in favor of global methods
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