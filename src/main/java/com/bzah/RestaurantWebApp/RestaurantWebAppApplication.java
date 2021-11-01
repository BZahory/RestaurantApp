package com.bzah.RestaurantWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RestaurantWebAppApplication {

    static Orders orders = new Orders(); //create a global variables of the Orders of the restaurant
    static Menu menu = new Menu(); //create a global variable for the Menu of the restaurant

    public static void main(String[] args) {
        SpringApplication.run(RestaurantWebAppApplication.class, args);
    }

}
