public class Item implements Buyable { //item must be buyable
    double price;
    String name;

    public Item(double price, String name) {
        this.price = price;
        this.name = name;
    }


    @Override
    public double getPrice() {
        return price;
    } //returns the price of the item

    @Override
    public String getName() {
        return name;
    } //returns the name of the item
}
