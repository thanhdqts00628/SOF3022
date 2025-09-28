package poly.edu.controller.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.model.lab2.Product;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController3 {
    @GetMapping("/lab2/products3")
    public String listProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            Model model) {

        List<Product> allProducts = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            allProducts.add(new Product("Product " + i, i * 10.0));
        }

        int start = page * size;
        int end = Math.min(start + size, allProducts.size());
        List<Product> products = allProducts.subList(start, end);
        int totalPages = (int) Math.ceil(allProducts.size() / (double) size);
        model.addAttribute("products", products);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", totalPages);
        return "lab2/product3Form";
    }
}