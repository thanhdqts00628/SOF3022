package poly.edu.controller.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Simple greeting controller that displays a hello message.
 */
@Controller
class Hello {
    
    /**
     * Display hello page with title and subject.
     * @param model Spring MVC model to pass data to view
     * @return template path for hello page
     */
    @RequestMapping("/lab1/hello")
    public String sayHello(Model model) {
        model.addAttribute("title", "FPT Polytechnic");
        model.addAttribute("subject", "Spring Boot MVC - Dương Quang Thanh");
        return "/lab1/hello";
    }
}