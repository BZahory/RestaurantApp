public class Order {
    boolean ready; //indicates whether the order is ready for pickup
    Item[] items; //an array of the items in the order

    public Order(Item[] items) {
        ready = false;
        this.items = items;
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

}