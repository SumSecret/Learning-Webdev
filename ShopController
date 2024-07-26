package com.example.testProject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // This annotation indicates that this class is a Spring MVC controller.
// Controllers handle user requests, process them, and return appropriate responses.
public class ShopController {
    // List to store the available items in the shop. This simulates a database.
    private List<Item> itemList = new ArrayList<>();
    // Instance of Cart, which will hold the items the user adds to their shopping cart.
    private Cart cart = new Cart();

    // Constructor initializes the shop with some sample items. 
    // In a real-world application, this data might come from a database.
    public ShopController() {
        itemList.add(new Item(1L, "Item 1", 10.0)); // Sample item 1 with ID, name, and price
        itemList.add(new Item(2L, "Item 2", 20.0)); // Sample item 2
        itemList.add(new Item(3L, "Item 3", 30.0)); // Sample item 3
    }

    @GetMapping("/") // Maps HTTP GET requests to the root URL ("/") to this method.
    // GET requests are used to retrieve data from the server.
    public String showItems(Model model) {
        // Adds the list of items to the model, making them available to the view (template).
        model.addAttribute("items", itemList);
        // Returns the name of the view to render, in this case, "items.html".
        return "items";
    }

    @PostMapping("/add-to-cart") // Maps HTTP POST requests to "/add-to-cart" to this method.
    // POST requests are used to submit data to the server, such as form submissions.
    public String addToCart(@RequestParam Long itemId, Model model) {
        // The @RequestParam annotation binds the 'itemId' parameter from the request to this method.
        // It identifies which item to add to the cart based on its ID.

        // Stream API is used to find the item with the matching ID in the itemList.
        itemList.stream()
                .filter(item -> item.getId().equals(itemId)) // Filters items to find the one with the given ID
                .findFirst() // Retrieves the first item matching the filter criteria
                .ifPresent(cart::addItem); // If an item is found, it is added to the cart

        // Adds the updated cart to the model, making its contents available to the view.
        model.addAttribute("cart", cart);
        // Returns the name of the view to render, in this case, "cart.html".
        return "cart";
    }

    @GetMapping("/cart") // Maps HTTP GET requests to "/cart" to this method.
    public String viewCart(Model model) {
        // Adds the current state of the cart to the model.
        model.addAttribute("cart", cart);
        // Returns the name of the view to render, in this case, "cart.html".
        return "cart";
    }
}
