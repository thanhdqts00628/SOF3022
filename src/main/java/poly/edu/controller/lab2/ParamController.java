package poly.edu.controller.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Demonstrates parameter handling in Spring MVC.
 * Shows @PathVariable and @RequestParam usage.
 */
@Controller
@RequestMapping("/lab2/param")
class ParamController {

    /**
     * Display the parameter form.
     * @return template path for parameter form
     */
    @RequestMapping("/form")
    public String form() {
        return "lab2/form";
    }

    /**
     * Save parameters from both path and query string.
     * @param x path variable from URL
     * @param y query parameter from form or URL
     * @param model Spring MVC model to pass parameters to view
     * @return template path for form with saved parameters
     */
    @RequestMapping("/save/{x}")
    public String save(@PathVariable String x, @RequestParam String y, Model model) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "lab2/form";
    }
}
