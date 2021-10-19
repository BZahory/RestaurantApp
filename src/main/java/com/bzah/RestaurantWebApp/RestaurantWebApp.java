import java.util.Scanner;

public class RestaurantWebApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Menu menu = new Menu();

		menu.printMenu();

		Order customerOrder = new Order(menu.getItems(sc));

		System.out.println("Here is your receipt: \n" + customerOrder.getReceipt());
	}
}