package poly.edu.controller.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.model.lab2.Product;

@Controller
@RequestMapping("/lab2/product")
class ProductController {
    @GetMapping("/form")
    public String form(Model model) {
        Product p = new Product();
        p.setName("Iphone 13");
        p.setPrice(3000.0);
        model.addAttribute("product", p);
        return "lab2/productForm";
    }

    @PostMapping("/save")
    public String save(Product product, Model model) {
        model.addAttribute("product", product);
        return "lab2/productForm";
    }
}
