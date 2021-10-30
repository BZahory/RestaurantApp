package com.bzah.RestaurantWebApp;

import java.io.Serializable;
import java.util.*;

import static com.bzah.RestaurantWebApp.RestaurantWebAppApplication.orders;

public class Orders implements Iterable<Order> {
    ArrayList<Order> orders;

    public Orders() {
        this.orders = new ArrayList<>();
    }

    public Order getOrderByNumber(Long index) {
        for (int i = 0; i < orders.size(); i++) {
            if (index.equals(orders.get(i).getOrderNumber()))
                return orders.get(i);
        }
        return null;
    }

    public void removeOrder(Long index) {
        for (int i = 0; i < orders.size(); i++) {
            if (index.equals(orders.get(i).getOrderNumber()))
                orders.remove(i);
        }
    }

    public void markOrderAsReady(Long index) {
        for (int i = 0; i < orders.size(); i++) {
            if (index.equals(orders.get(i).getOrderNumber()))
                orders.get(i).setReady(true);
        }
    }

    public void add(Order order) {
        orders.add(order);
    }

    @Override
    public Iterator<Order> iterator() {//allows usages of for-each loops
        return orders.iterator();
    }

    public boolean containsOrderNumber(Long number) {
        for (int i = 0; i < orders.size(); i++) {
            if (number.equals(orders.get(i).getOrderNumber()))
                return true;
        }
        return false;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}