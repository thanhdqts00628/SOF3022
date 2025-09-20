package poly.edu.controller.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/lab1/login")
public class Auth {
    final
    HttpServletRequest request;

    public Auth(HttpServletRequest request) {
        this.request = request;
    }

    @RequestMapping("/form")
    public String form() {
        return "lab1/form";
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String login(Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("poly".equals(username) && "123".equals(password)) {
            model.addAttribute("message", "Login successful!");
        } else {
            model.addAttribute("message", "Login failed. Invalid username or password.");
        }
        return "lab1/form";
    }
}
