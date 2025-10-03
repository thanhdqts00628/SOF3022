package poly.edu.controller.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Authentication controller for handling login functionality.
 * Validates credentials and provides feedback.
 */
@Controller
@RequestMapping("/lab1/login")
public class Auth {
    
    /**
     * Display the login form.
     * @return template path for login form
     */
    @RequestMapping("/form")
    public String form() {
        return "lab1/form";
    }

    /**
     * Process login request and validate credentials.
     * Valid credentials: username="poly", password="123"
     * 
     * @param username user's username
     * @param password user's password
     * @param model Spring MVC model to pass result message
     * @return template path for login form with result message
     */
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        // Validate credentials against hardcoded values
        if ("poly".equals(username) && "123".equals(password)) {
            model.addAttribute("message", "Login successful!");
        } else {
            model.addAttribute("message", "Login failed. Invalid username or password.");
        }
        return "lab1/form";
    }
}
