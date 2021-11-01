package com.bzah.RestaurantWebApp;

/**
 * Represents an Item that is Buyable.
 *
 * @author Bilal Zahory
 * @author www.bzah.bz
 */

public class Item implements Buyable {

    double price;
    String name;

    /**
     * Creates a nameless, free item.
     */
    public Item() {
        name = "";
        price = 0.00;
    }

    /**
     * Creates an item with the specified name and price.
     *
     * @param price The specified price of the item.
     * @param name  The specified name of the item.
     */
    public Item(double price, String name) {
        this.price = price;
        this.name = name;
    }

    /**
     * Gets the item's price.
     *
     * @return The unformatted price of the item.
     */
    @Override
    public double getPrice() {
        return price;
    } //returns the price of the item

    /**
     * Sets the item's price.
     *
     * @param price The specified price of the item.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the item's name.
     *
     * @return The name of the item.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the item's name.
     *
     * @param name The specified name of the item.
     */
    public void setName(String name) {
        this.name = name;
    }
}
