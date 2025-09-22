package poly.edu.controller.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ctrl")
class OkController {
    @RequestMapping("/ok")
    public String ok() {
        return "lab2/ok";
    }

    public String m1() {
        return "lab2/ok";
    }

    public String m2() {
        return "lab2/ok";
    }

    public String m3() {
        return "lab2/ok";
    }
}
