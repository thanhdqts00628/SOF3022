package poly.edu.controller.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Demonstrates different navigation flows in Spring MVC.
 * Shows forward vs redirect and different ways to pass data.
 */
@Controller
@RequestMapping("/lab2")
public class resultController {

    /**
     * Display result page.
     * This is the target page for forward and redirect operations.
     * @return template path for result page
     */
    @RequestMapping("/a")
    public String m1() {
        return "lab2/result";
    }

    /**
     * Forward to /a with model attribute.
     * Forward keeps the model data and happens server-side.
     * URL in browser remains /lab2/b.
     * @param model Spring MVC model with message attribute
     * @return forward directive to /lab2/a
     */
    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "forward:/lab2/a"; // Forward keeps model data
    }

    /**
     * Redirect to /a with query parameter.
     * Redirect causes browser to make new request.
     * URL in browser changes to /lab2/a?message=...
     * @param params RedirectAttributes to add query parameter
     * @return redirect directive to /lab2/a
     */
    @RequestMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return "redirect:/lab2/a";
    }

    /**
     * Return plain text response (not a view).
     * @ResponseBody tells Spring to write string directly to HTTP response.
     * @return plain text message
     */
    @ResponseBody
    @RequestMapping("/d")
    public String m4() {
        return "I come from d";
    }
}
