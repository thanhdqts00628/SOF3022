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

@Controller
@RequestMapping("/lab2/product2")
class ProductController2 {
    private final List<Product> items = new ArrayList<>();

    @ModelAttribute("products")
    public List<Product> products() {
        return items;
    }

    @GetMapping("/form")
    public String form(Model model) {
        if (items.isEmpty()) items.add(0, new Product("iPhone 30", 5000.0));
        addCurrentAndNext(model);
        return "lab2/product2Form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product p, Model model) {
        if (p.getName() != null || p.getPrice() != null) items.add(0, new Product(p.getName(), p.getPrice()));
        addCurrentAndNext(model);
        return "lab2/product2Form";
    }

    private void addCurrentAndNext(Model model) {
        Product current = items.isEmpty() ? null : items.get(0); // ?1
        Product next = items.size() > 1 ? items.get(1) : null;   // ?2
        model.addAttribute("product", current);
        model.addAttribute("nextProduct", next);
    }
}
