package com.example.testProject;


import java.util.ArrayList;
import java.util.List;

// Represents a shopping cart containing items
public class Cart {
    private List<Item> items = new ArrayList<>(); // List to store items added to the cart

    // Adds an item to the cart
    public void addItem(Item item) {
        items.add(item);
    }

    // Returns the list of items in the cart
    public List<Item> getItems() {
        return items;
    }

    // Calculates the total price of the items in the cart
    public double getTotal() {
        double total = 0; // Variable to store the total price
        for (Item item : items) { // Iterate through each item in the cart
            total += item.getPrice(); // Add the price of the item to the total
        }
        return total; // Return the calculated total price
    }
}
