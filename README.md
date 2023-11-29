
# Restaurant Ordering System

This Java-based project streamlines food ordering from multiple restaurants through the command line. It leverages Object-Oriented Programming (OOP) principles to provide a user-friendly interface for restaurant selection, menu viewing, item selection, cart management, and receipt generation.


## Table of Contents

1. [Overview](#project-goals)
2. [Structure](#structure)
3. [Classes](#classes)
   1. [FoodItem](#fooditem)
   2. [Restaurant](#restaurant)
   3. [Main](#main)
4. [How to Use](#how-to-use)
5. [Example Usage](#example-usage)
6. [CSV Reader (Supplementary Class)](#csv-reader-supplementary-class)


## Overview

- **Food Ordering System**
- Restaurant menus in the form of CSV files are put in the command line.
- User picks which restaurant they want to order from and then what items they want.
- At the end, the program prints a "receipt."

## Structure

- We created a food ordering system that obtains restaurants by reading menu CSV files.
- CSV files allow for restaurants to be easily added and discarded from the program.
- 3 classes: FoodItem -> Restaurant -> Main
- Supplementary classes: CSV reader, Scanner

## Classes

### FoodItem

- **Fields:**
  - `name`: The name of the food item.
  - `price`: The price of the food item.
  - `allergens`: Any allergens associated with the food item (all Strings).

- **Constructor:** Takes all fields as parameters.

- **Methods:**
  - `getName()`: Getter method to retrieve the name of the food item.
  - `getPrice()`: Getter method to retrieve the price of the food item.
  - `getAllergens()`: Getter method to retrieve the allergens associated with the food item.
  - `toString()`: String representation of the food item object.

### Restaurant

- **Fields:**
  - `menu`: Menu ArrayList of FoodItem objects.
  - `name`: The name of the restaurant.

- **Constructor:** Reads a CSV file, turns each line into a FoodItem object, adds them to the menu. The name is derived from the CSV file name without the ".csv" extension.

- **Methods:**
  - `getMenu()`: Returns the menu of available food items.
  - `getName()`: Returns the name of the restaurant.
  - `getMenuSize()`: Returns the number of items on the restaurant's menu.
  - `toString()`: String representation of the restaurant's menu.
  - `allergensMenu()`: String representation of the restaurant's menu, including allergen information.

### Main

- The Main class implements an application that allows the user to choose a restaurant from the given list and order food items from its menu.
- The user can choose to see the menu with allergens or only the menu, add food items to the cart, view the cart, and checkout.

## How to Use

1. Run the program with restaurant menu CSV files as command line arguments.
2. Choose a restaurant from the list.
3. Select whether to see the menu with allergens or without.
4. Add food items to the cart.
5. View the cart or proceed to checkout.
6. Review the receipt with the total price.

## Example Usage

```shell
java Main GrillMenu.csv
```

## CSV Reader (Supplementary Class)
- The CSVReader class contains two main methods: read and close and is designed to handle potential IOExceptions that may occur during file reading, and it prints the stack trace for any such exceptions.
