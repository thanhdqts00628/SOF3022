package poly.edu.controller.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.model.lab2.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Product pagination controller.
 * Demonstrates pagination with page and size parameters.
 */
@Controller
public class ProductController3 {
    
    /**
     * List products with pagination support.
     * Generates 20 demo products and displays them in pages.
     * 
     * @param page current page number (default: 0)
     * @param size number of items per page (default: 5)
     * @param model Spring MVC model to pass pagination data
     * @return template path for paginated product list
     */
    @GetMapping("/lab2/product3")
    public String listProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            Model model) {

        // Generate demo product list
        List<Product> allProducts = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            allProducts.add(new Product("Product " + i, i * 10.0));
        }

        // Calculate pagination boundaries
        int start = page * size;
        int end = Math.min(start + size, allProducts.size());
        
        // Get products for current page
        List<Product> products = allProducts.subList(start, end);
        
        // Calculate total pages
        int totalPages = (int) Math.ceil(allProducts.size() / (double) size);
        
        // Pass data to view
        model.addAttribute("products", products);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", totalPages);
        return "lab2/product3Form";
    }
}