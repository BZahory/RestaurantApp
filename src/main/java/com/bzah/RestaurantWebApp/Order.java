package com.bzah.RestaurantWebApp;

import java.util.Optional;

/**
 * Represents an array of items.
 *
 * @author Bilal Zahory
 * @author www.bzah.bz
 */

public class Order {

    private long orderNumber;
    private boolean ready = false; //indicates whether the order is ready for pickup
    private Item[] items; //an array of Item objects
    private String itemsString; //a comma-separated list of the items, holds input until the string can be processed


    /**
     * Gets the array of items in the order.
     * @return The array of items in the order.
     */
    public Item[] getItems() {
        return items;
    }

    /**
     * Sets the itemsString class variable.
     * @link{#processStrings(Menu)} is used to actually create the items array.
     *
     * @param orderInput The comma-separated list of desired items.
     */
    public void setItems(String orderInput) {
        this.itemsString = orderInput;
    }

    /**
     * Get the raw input for the orders
     * @return A String of the orders, separated by commas.
     */
    public String getItemsString() {
        return itemsString;
    }

    /**
     * Set the raw input for the string.
     * @param string A String of the Orders' names, separated by commas.
     */
    public void setItemsString(String string){
        this.itemsString = string;
    }

    /**
     * Get the order number.
     * @return The order number.
     */
    public long getOrderNumber() {
        return orderNumber;
    }

    /**
     * Set the order number.
     *
     * @param orderNumber The specified order number.
     */
    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Creates a list of all the items in the order, while calculating the total.
     * The US Dollar sign, '$', is affixed to all prices.
     *
     * @return A formatted list of all the items and prices; it also returns the total.
     */
    public String getReceipt() {
        StringBuilder sb = new StringBuilder(); //StringBuilder is suited for when operations are done on the string
        double sum = 0.0;
        for (Item x :
                items) {
            sb.append(x.getName() + ":\t $" + x.getPrice() + "\n");
            sum += x.getPrice();
        }

        sb.append("total" + ":\t $" + sum);

        return sb.toString();
    }

    /**
     * Get the order status.
     * @return Whether or not the order is ready.
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * Set the order status.
     *
     * @param temp Whether or not the order is ready.
     */
    public void setReady(boolean temp) {
        this.ready = temp;
    }

    /**
     * Uses the given Menu for the order to process the
     * itemsString (Which could be set using @link{#setItems(String)})
     * into the items array.
     *
     * @param menu The Menu for the items in the order.
     */
    public void processString(Menu menu) {

        String[] itemsList = itemsString.split(","); //creates an array from the comma-separated list
        items = new Item[itemsList.length];
        for (int i = 0; i < itemsList.length; i++) {
            //uses optionals to make a placeholder Item, if the Item is not on the Menu
            Item desiredItem = Optional.ofNullable(menu.getMenu().get(itemsList[i])).orElse(
                    new Item(0.00, "Item Unavailable"));
            items[i] = desiredItem;
        }
    }
}