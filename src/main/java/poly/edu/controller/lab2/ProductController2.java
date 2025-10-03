package poly.edu.controller.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.model.lab2.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Product list controller with @ModelAttribute demonstration.
 * Maintains a list of products and displays most recent items.
 */
@Controller
@RequestMapping("/lab2/product2")
class ProductController2 {
    // In-memory product storage (new items added to front)
    private final List<Product> items = new ArrayList<>();

    /**
     * Model attribute method - automatically adds products list to all responses.
     * @return full product list
     */
    @ModelAttribute("products")
    public List<Product> products() {
        return items;
    }

    /**
     * Display product form with current and next product.
     * Initializes list with default product if empty.
     * @param model Spring MVC model
     * @return template path for product form
     */
    @GetMapping("/form")
    public String form(Model model) {
        // Add default product if list is empty
        if (items.isEmpty()) items.add(0, new Product("iPhone 30", 5000.0));
        addCurrentAndNext(model);
        return "lab2/product2Form";
    }

    /**
     * Save new product to the list.
     * New product is added to the front of the list.
     * @param p product from form
     * @param model Spring MVC model
     * @return template path for product form
     */
    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product p, Model model) {
        // Add product to front of list if it has data
        if (p.getName() != null || p.getPrice() != null) items.add(0, new Product(p.getName(), p.getPrice()));
        addCurrentAndNext(model);
        return "lab2/product2Form";
    }

    /**
     * Helper method to add current and next product to model.
     * Current = most recent item, Next = second most recent item.
     * @param model Spring MVC model
     */
    private void addCurrentAndNext(Model model) {
        Product current = items.isEmpty() ? null : items.get(0); // Most recent product
        Product next = items.size() > 1 ? items.get(1) : null;   // Second most recent product
        model.addAttribute("product", current);
        model.addAttribute("nextProduct", next);
    }
}
