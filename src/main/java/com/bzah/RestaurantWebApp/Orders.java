package com.bzah.RestaurantWebApp;

import java.util.*;

/**
 * Represents an Arraylist of Order objects.
 *
 * @author Bilal Zahory
 * @author www.bzah.bz
 */


public class Orders implements Iterable<Order> {
    ArrayList<Order> orders;

    /**
     * Initializes an empty ArrayList for orders.
     */
    public Orders() {
        this.orders = new ArrayList<>();
    }

    /**
     * Get the orders.
     * @return the ArrayList of orders.
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * Retrieves an Order using its order number.
     *
     * @param index The target Order's order number.
     * @return The Order if it is found, otherwise return null.
     */
    public Order getOrderByNumber(Long index) {
        for (int i = 0; i < orders.size(); i++) {
            if (index.equals(orders.get(i).getOrderNumber()))
                return orders.get(i);
        }
        return null; //return null if the order doesn't exist
    }

    /**
     * Removes an Order using its order number.
     *
     * @param index The target Order's order number.
     */
    public void removeOrderByNumber(Long index) {
        for (int i = 0; i < orders.size(); i++) {
            if (index.equals(orders.get(i).getOrderNumber()))
                orders.remove(i);
        }
    }

    /**
     * Marks an Order as ready, using its order number.
     *
     * @param index The target Order's order number.
     */
    public void markOrderAsReady(Long index) {
        for (int i = 0; i < orders.size(); i++) {
            if (index.equals(orders.get(i).getOrderNumber()))
                orders.get(i).setReady(true);
        }
    }

    /**
     * Checks if ArrayList orders contains an Order with a given order number.
     * @param index The target Order's order number.
     * @return Whether or not the Order exists.
     */
    public boolean containsOrderNumber(Long index) {
        for (int i = 0; i < orders.size(); i++) {
            if (index.equals(orders.get(i).getOrderNumber()))
                return true;
        }
        return false;
    }

    /**
     * Adds an Order to ArrayList orders.
     * @param order The order to be added.
     */
    public void add(Order order) {
        orders.add(order);
    }

    /**
     * Returns the iterator for ArrayList orders.
     * @return The iterator for ArrayList orders.
     */
    @Override
    public Iterator<Order> iterator() {
        return orders.iterator();
    }
}