import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 The Main class implements an application that allows the user to choose a restaurant from the given list
 and order food items from its menu. The user can choose to see the menu with allergens or only the menu,
 add food items to the cart, show the cart, checkout and see the total price.
 */
public class Main {
    /**
     * The main method that allows the user to interact with the ordering system.
     * This method creates restaurant objects from command line arguments, displays the menu and allergens,
     * and allows the user to add items to the cart, view the cart, and checkout.
     * @param args an array of Strings containing the names of the restaurants
     * @throws FileNotFoundException if the specified file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        //initializes variables
        Scanner scanner = new Scanner(System.in);
        ArrayList<FoodItem> order = new ArrayList<>();
        int choice = 0;
        //creates restaurants from command line
        String[] restaurants = args;
        ArrayList<Restaurant> restaurantsToChoose = new ArrayList<>();
        for (String n : restaurants) {     // creates a restaurant object for each command line argument
            Restaurant s = new Restaurant(n);
            restaurantsToChoose.add(s);
        }
        scanner = new Scanner(System.in); // create a new Scanner object to read input from the console and assign it to the variable 'scanner'
        while (choice != restaurantsToChoose.size()) {
            //Show restaurant options
            for (Restaurant n : restaurantsToChoose) {
                System.out.println(restaurantsToChoose.indexOf(n) + " " + n.getName()); // loop through each Restaurant object in the 'restaurantsToChoose' ArrayList and print out its index in the ArrayList and its name to the console using the 'System.out.println()' method.
            }
            System.out.println(restaurantsToChoose.size() + " " + "Cancel Order");
            choice = scanner.nextInt();
            if (choice == restaurantsToChoose.size()) {
                System.out.println("Thank you , Good bye!"); //if the user choose to cancel the order, it print a goodbye message
                return;
            }
            Restaurant chosen = restaurantsToChoose.get(choice);
            System.out.println("Type in Y to see the menu allergens or N for only the menu");
            String yOrN = "";
            yOrN = (scanner.next()).toUpperCase(); // read user input and convert to uppercase
            if (yOrN.equals("Y")) { // if the user entered "Y" print the allergens menu for the chosen restaurant
                System.out.println(chosen.allergensMenu());
            } else if (yOrN.equals("N")) { // if the user entered "N" print the regular menu for the chosen restaurant
                System.out.println(chosen);
            } else {
                while ((yOrN.equals("Y") || yOrN.equals("N")) == false) {      // if the user entered something other than "Y" or "N" continue to prompt until user enters a valid input
                    System.out.println("invalid input...Please type in Y or N");
                    yOrN = (scanner.next()).toUpperCase();
                }
                if (yOrN.equals("Y")) { // if the user entered "Y" print the allergens menu for the chosen restaurant
                    System.out.println(chosen.allergensMenu());
                } else if (yOrN.equals("N")) { // if the user entered "N" print the regular menu for the chosen restaurant
                    System.out.println(chosen);
                }
            }
            int foodChoice = 0;
            while (foodChoice != -1 || foodChoice != -2) { // A while loop that prompts the user to choose an item from the menu and handles the different input scenarios
                System.out.println("Please choose an item from the menu:");
                System.out.println("Insert -1 to return to the main menu");
                System.out.println("Insert -2 to show the cart");
                System.out.println("Insert -3 to checkout");
                // Ask user for input
                foodChoice = scanner.nextInt();
                if (foodChoice >= 0 && foodChoice < chosen.getMenuSize()) { //check if the user input is a valid menu item number, if it is, add the selected item to the cart and print a message
                    order.add(chosen.getMenu().get(foodChoice));
                    System.out.println("Added " + chosen.getMenu().get(foodChoice).getName() + " to cart.");

                } else if (foodChoice >= chosen.getMenuSize()) {     // If the user input is not a valid menu item number, print an error message and continue the loop
                    System.out.println("Please enter a valid menu item number.");
                    continue;
                } else if (foodChoice == -1) {     // If the user inputs -1, break out of the loop and return to the main menu
                    break;
                } else if (foodChoice == -2) {     // If the user inputs -2, print the contents of the cart
                    if (order.isEmpty()) {
                        System.out.println("Your cart is empty");
                    } else {
                        System.out.println(order);
                    }
                } else if (foodChoice == -3) {  // show the items in the cart and the total price
                    if (order.isEmpty()) {
                        System.out.println("Your cart is empty");
                    }
                    for (FoodItem item : order) { // iterate over the items in the cart and print them out
                        System.out.println(item);
                    }
                    double totalPrice = 0;
                    for (int i = 0; i < order.size(); i++) { // calculate the total price by summing up the price of all items in the cart
                        totalPrice += order.get(i).getPrice();
                    }
                    System.out.println("The total price would be $" + totalPrice + "."); // print the total price
                    return; // exit the method
                    } else { // if the input is not a valid menu item number, -1, -2 or -3, print an error message in red.
                    System.out.println("Choose a valid input");}
            }
        }
    }
}