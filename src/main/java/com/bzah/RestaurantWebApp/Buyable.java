package com.bzah.RestaurantWebApp;

/**
 * The Buyable interface requires that a class contains
 * a price and a name for each item.
 * @author Bilal Zahory
 * @author www.bzah.bz
 */

public interface Buyable {

    /**
     * Gets the price of the object.
     * @return The price of the item.
     */
    double getPrice();

    /**
     * Gets the name of the object.
     * @return The name of the object.
     */
    String getName(); //gets the name of the Buyable object
}
