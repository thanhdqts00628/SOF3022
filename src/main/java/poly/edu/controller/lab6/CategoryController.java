package poly.edu.controller.lab6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.dao.lab6.CategoryRepository;
import poly.edu.model.lab6.Category;

@Controller
@RequestMapping("/lab6/category")
public class CategoryController {
    String url = "/lab6/CategoryManagement";
    String redirect = "redirect:/lab6/category/index";

    final
    CategoryRepository categoryRepo;

    public CategoryController(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {
        // Load the category to be edited on form
        Category item = categoryRepo.findById(id).orElse(null);
        model.addAttribute("item", item);

        // Load all categories to display in the table
        model.addAttribute("items", categoryRepo.findAll());
        return url;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("item") Category item, Model model) {
        // Save the new category
        categoryRepo.save(item);

        // Clear the form
        model.addAttribute("item", new Category());

        // Load all categories to display in the table
        model.addAttribute("items", categoryRepo.findAll());
        return redirect;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("item") Category item, Model model) {
        // Update only if the category exists
        if (item.getId() != null && categoryRepo.existsById(item.getId())) {
            categoryRepo.save(item);
        }

        // Clear the form
        model.addAttribute("item", new Category());

        // Load all categories to display in the table
        model.addAttribute("items", categoryRepo.findAll());
        return "redirect:/lab6/category/edit/" + item.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        // Delete only if the category exists
        if (categoryRepo.existsById(id)) {
            categoryRepo.deleteById(id);
        }

        // Clear the form
        model.addAttribute("item", new Category());

        // Load all categories to display in the table
        model.addAttribute("items", categoryRepo.findAll());
        return redirect;
    }

    @RequestMapping("/index")
    public String reset(Model model) {
        // Clear the form
        model.addAttribute("item", new Category());

        // Load all categories to display in the table
        model.addAttribute("items", categoryRepo.findAll());
        return url;
    }
}
