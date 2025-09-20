package poly.edu.controller.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lab1/login")
public class Auth {
    @RequestMapping("/form")
    public String form() {
        return "lab1/form";
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {

        if ("poly".equals(username) && "123".equals(password)) {
            model.addAttribute("message", "Login successful!");
        } else {
            model.addAttribute("message", "Login failed. Invalid username or password.");
        }
        return "lab1/form";
    }
}
