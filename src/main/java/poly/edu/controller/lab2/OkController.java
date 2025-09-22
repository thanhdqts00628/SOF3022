package poly.edu.controller.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ctrl")
class OkController {
    @RequestMapping("/ok")
    public String ok() {
        return "lab2/ok";
    }

    @PostMapping("/ok")
    public String m1(Model model) {
        model.addAttribute("methodName", "m1");
        return "lab2/ok";
    }

    @GetMapping("/ok")
    public String m2(Model model) {
        model.addAttribute("methodName", "m2");
        return "lab2/ok";
    }

    @PostMapping(value = "/ok", params = "x")
    public String m3(Model model) {
        model.addAttribute("methodName", "m3");
        return "lab2/ok";
    }
}
