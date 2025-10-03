package poly.edu.controller.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Demonstrates different HTTP method mappings.
 * Shows how Spring routes requests based on HTTP method and parameters.
 */
@Controller
@RequestMapping("/lab2/ctrl")
class OkController {
    
    /**
     * Handle POST request to /ok.
     * @param model Spring MVC model
     * @return template path with method name
     */
    @PostMapping("/ok")
    public String m1(Model model) {
        model.addAttribute("methodName", "m1");
        return "lab2/ok";
    }

    /**
     * Handle GET request to /ok.
     * @param model Spring MVC model
     * @return template path with method name
     */
    @GetMapping("/ok")
    public String m2(Model model) {
        model.addAttribute("methodName", "m2");
        return "lab2/ok";
    }

    /**
     * Handle POST request to /ok with parameter 'x'.
     * This method has higher priority than m1 when 'x' parameter is present.
     * @param model Spring MVC model
     * @return template path with method name
     */
    @PostMapping(value = "/ok", params = "x")
    public String m3(Model model) {
        model.addAttribute("methodName", "m3");
        return "lab2/ok";
    }
}
