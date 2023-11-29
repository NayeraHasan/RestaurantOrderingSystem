/**
 * A class representing a food item with its name, price, and allergens.
 */
public class FoodItem {
    String name; // the name of the food item
    String price; // the price of the food item
    String allergens; // any allergens associated with the food item
    /**
     * Constructor to initialize the food item with its name, price, and allergens.
     * @param n The name of the food item.
     * @param a The allergens associated with the food item.
     * @param p The price of the food item.
     */
    public FoodItem(String n, String a, String p) {
        name = n;
        price = p;
        allergens = a;
    }

    /**
     * Getter method to retrieve the name of the food item.
     * @return The name of the food item.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method to retrieve the price of the food item.
     * @return The price of the food item.
     */
    public double getPrice() {
        return Double.parseDouble(price);
    }

    /**
     * Getter method to retrieve the allergens associated with the food item.
     * @return The allergens associated with the food item.
     */
    public String getAllergens() {
        return allergens;
    }
    /**
     * String representation of the food item object.
     *
     * @return A string representing the food item object with its price and name.
     */
    public String toString() {
        String format = "  %-35s %-1s %-1s";
        StringBuilder menuFormat = new StringBuilder();
        menuFormat.append(String.format(format, " " + name, " ", "$" + price));
        return menuFormat.toString();
    }
}