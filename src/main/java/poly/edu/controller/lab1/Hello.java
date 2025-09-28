package poly.edu.controller.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class Hello {
    @RequestMapping("/lab1/hello")
    public String sayHello(Model model) {
        model.addAttribute("title", "FPT Polytechnic");
        model.addAttribute("subject", "Spring Boot MVC - Dương Quang Thanh");
        return "/lab1/hello";
    }
}