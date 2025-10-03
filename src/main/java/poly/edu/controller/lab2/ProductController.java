package poly.edu.controller.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.model.lab2.Product;

/**
 * Simple product form controller.
 * Demonstrates basic form binding with a product object.
 */
@Controller
@RequestMapping("/lab2/product")
class ProductController {
    
    /**
     * Display product form with initial data.
     * @param model Spring MVC model with default product
     * @return template path for product form
     */
    @GetMapping("/form")
    public String form(Model model) {
        // Create default product for demonstration
        Product p = new Product();
        p.setName("Iphone 13");
        p.setPrice(3000.0);
        model.addAttribute("product", p);
        return "lab2/productForm";
    }

    /**
     * Save product submitted from form.
     * Spring automatically binds form fields to Product object.
     * @param product product data from form
     * @param model Spring MVC model to display saved product
     * @return template path for product form with saved data
     */
    @PostMapping("/save")
    public String save(Product product, Model model) {
        model.addAttribute("product", product);
        return "lab2/productForm";
    }
}
