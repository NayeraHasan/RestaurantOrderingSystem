import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Restaurant {

    private ArrayList<FoodItem> menu; // The menu of available food items
    private String name;

    /**
     * Constructs a new Restaurant object by reading a CSV file containing the menu
     * of available food items.
     * @param file the name of the CSV file containing the menu
     * @throws FileNotFoundException if the specified file is not found
     */
    public Restaurant(String file) throws FileNotFoundException {
        CSVReader reader = new CSVReader();
        FileReader input = new FileReader(file);
        ArrayList<String[]> list;
        list = reader.read(input);
        menu = new ArrayList<FoodItem>(); // initialize menu list

        // loop through the CSV file and create FoodItem objects from each row
        for (String[] s : list) {
            FoodItem food = new FoodItem(s[0], (s[1]), (s[2]));
            menu.add(food);
        }
        // set the name of the restaurant to be the file name without the .csv extension
        name = file.substring(0, file.length() - 4);
    }

    /**
     * Returns the menu of available food items.
     * @return the menu of available food items
     */
    public ArrayList<FoodItem> getMenu() {
        return menu;
    }
    /**
     * Returns the name of the restaurant.
     * @return the name of the restaurant
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of items on the restaurant's menu.
     * @return the number of items on the menu
     */
    public int getMenuSize() {
        return menu.size();
    }

    /**
     * Returns a String representation of the restaurant's menu.
     * @return a String representation of the restaurant's menu
     */
    public String toString() {
        String str = "";
        // loop through the menu and append each item's string representation to the
        // output string
        for (FoodItem item : menu) {
            str += menu.indexOf(item) + item.toString() + "\n";
        }
        return str;
    }
    /**
     * Returns a String representation of the restaurant's menu, including allergen
     * information.
     * @return a String representation of the restaurant's menu with allergen information
     */
    public String allergensMenu() {
        String str = "";
        // loop through the menu and append each item's string representation with
        // allergen information to the output string
        for (FoodItem item : menu) {
            System.out.printf("%-2s %-35s $%-10s %-20s\n",
                    menu.indexOf(item),
                    item.getName(),
                    item.getPrice(),
                    item.getAllergens());
        }
        return str;
    }
}

