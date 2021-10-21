package com.bzah.RestaurantWebApp;

import java.io.Serializable;
import java.util.Optional;

public class Order{
    private long orderNumber;
    private boolean ready = false; //indicates whether the order is ready for pickup
    private Item[] items; //an array of the items in the order
    private String itemsString;


    public String getItemsString() {
        return itemsString;
    }

    public void setItemsString(String string){
        this.itemsString = string;
    }

    public void setItems(String orderInput) {
        this.itemsString = orderInput;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getReceipt(){ //returns a list of all the items and prices, and the total
        StringBuilder sb = new StringBuilder(); //better for when operations are done on the string
        double sum = 0.0;
        for (Item x:
             items) {
            sb.append(x.getName() + ":\t" + x.getPrice() + "\n");
            sum += x.getPrice();
        }

        sb.append("total" + ":\t" + sum);

        return sb.toString();
    }

    public boolean isReady(){ //returns the order status
        return ready;
    }
    public void setReady(boolean temp){
        this.ready = temp;
    }
    public void processString(Menu menu){

        String[] itemsList = itemsString.split(",");
        items = new Item[itemsList.length];
        for(int i = 0; i < itemsList.length; i++){
            Item desiredItem = Optional.ofNullable(menu.getMenu().get(itemsList[i])).orElse(
                    new Item(0.00, "Item Unavailable"));
            items[i] = desiredItem;
        }
    }

    public Item[] getItems() {
        return items;
    }
}