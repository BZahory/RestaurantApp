package com.bzah.RestaurantWebApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
    HashMap<String, Item> menu = new HashMap<>(); //creates a menu of the items

    public Menu() { //adds items to the menu
        menu.put("javaCoffee", new Item(3.99, "javaCoffee"));
        menu.put("springRoll", new Item(4.49, "springRoll"));
        menu.put("oraCake", new Item(9.99, "oraCake"));
    }

    public HashMap<String, Item> getMenu() {
        return menu;
    }


    public void printMenu(){ //prints the menu to the terminal
        System.out.println("Here is the menu:");

        for (Item value : menu.values()) {
            System.out.println(value.getName() + ":\t" + value.getPrice() + "\n");
        }
    }
}