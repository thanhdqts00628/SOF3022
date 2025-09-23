package poly.edu.controller.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param")
class ParamController {

    @RequestMapping("/form")
    public String form() {
        return "lab2/form";
    }

    @RequestMapping("/save/{x}")
    public String save(@PathVariable String x, @RequestParam String y, Model model) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "lab2/form";
    }
}
