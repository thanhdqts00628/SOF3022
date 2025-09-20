package poly.edu.controller.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lab1/rectangle")
public class RectangleController {
    @RequestMapping("/form")
    public String form() {
        return "lab1/rectangle";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST)
    public String calc(@RequestParam("width") double width,
                       @RequestParam("length") double length,
                       Model model) {
        double perimeter = 2 * (width + length);
        double area = width * length;

        model.addAttribute("width", width);
        model.addAttribute("length", length);
        model.addAttribute("perimeter", perimeter);
        model.addAttribute("area", area);
        return "lab1/rectangle";
    }
}

