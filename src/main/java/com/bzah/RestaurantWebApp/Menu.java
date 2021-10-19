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

    public Item[] getItems(Scanner sc){ //returns a list of all the items and prices the customer wants

        ArrayList<Item> items = new ArrayList<>();
        boolean done = false;
        Optional<Item> desiredItem = Optional.empty();

        while(!done){
            System.out.println("Would you like to add anything else to the order?");

            if(sc.nextLine().toLowerCase().charAt(0)=='n') {
                done = true;
            }else {
                System.out.println("What would you like to add to the order?");

                desiredItem = Optional.ofNullable(menu.get(sc.nextLine()));

                if (desiredItem.isPresent())
                    items.add(desiredItem.get());
                else
                    System.out.println("That is not on the menu.");
            }

        }
        return items.toArray(new Item[items.size()]);
    }


    public void printMenu(){ //prints the menu to the terminal
        System.out.println("Here is the menu:");

        for (Item value : menu.values()) {
            System.out.println(value.getName() + ":\t" + value.getPrice() + "\n");
        }
    }
}