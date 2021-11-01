package com.bzah.RestaurantWebApp;

import java.util.HashMap;

/**
 * Represents an Arraylist of Order objects.
 *
 * @author Bilal Zahory
 * @author www.bzah.bz
 */

public class Menu {

    HashMap<String, Item> menu = new HashMap<>();

    /**
     * Creates a menu with three demo Item objects.
     */
    public Menu() {
        menu.put("javaCoffee", new Item(3.99, "javaCoffee"));
        menu.put("springRoll", new Item(4.49, "springRoll"));
        menu.put("oraCake", new Item(9.99, "oraCake"));
    }

    /**
     * Get the Menu.
     * @return The Menu HashMap.
     */
    public HashMap<String, Item> getMenu() {
        return menu;
    }


    /**
     * @deprecated Used for testing purposes in an earlier stage of the app.
     * Prints the menu to the terminal.
     */
    public void printMenu() { //prints the menu to the terminal
        System.out.println("Here is the menu:");

        for (Item value : menu.values()) {
            System.out.println(value.getName() + ":\t" + value.getPrice() + "\n");
        }
    }
}