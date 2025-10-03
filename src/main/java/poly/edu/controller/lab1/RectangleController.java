package poly.edu.controller.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Rectangle calculator controller.
 * Calculates perimeter and area based on width and length.
 */
@Controller
@RequestMapping("/lab1/rectangle")
public class RectangleController {
    
    /**
     * Display the rectangle calculator form.
     * @return template path for rectangle form
     */
    @RequestMapping("/form")
    public String form() {
        return "lab1/rectangle";
    }

    /**
     * Calculate rectangle perimeter and area.
     * Formulas: perimeter = 2 * (width + length), area = width * length
     * 
     * @param width rectangle width
     * @param length rectangle length
     * @param model Spring MVC model to pass calculation results
     * @return template path for rectangle form with results
     */
    @RequestMapping(value = "/calc", method = RequestMethod.POST)
    public String calc(@RequestParam("width") double width,
                       @RequestParam("length") double length,
                       Model model) {
        // Calculate perimeter and area
        double perimeter = 2 * (width + length);
        double area = width * length;

        // Pass inputs and results to view
        model.addAttribute("width", width);
        model.addAttribute("length", length);
        model.addAttribute("perimeter", perimeter);
        model.addAttribute("area", area);
        return "lab1/rectangle";
    }
}

