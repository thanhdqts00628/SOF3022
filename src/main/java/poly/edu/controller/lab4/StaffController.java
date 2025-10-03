package poly.edu.controller.lab4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.model.lab4.Staff;

@Controller
@RequestMapping("/staff")
class StaffController {

    @RequestMapping("/create/form")
    public String createForm(Model model, @ModelAttribute("staff") Staff staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "lab4/create-staff";
    }

    @RequestMapping("create/save")
    public String createSave(Model model, @ModelAttribute("staff") Staff staff,
                             @RequestPart("photo_file") MultipartFile photoFile) {
        // Gán tên ảnh được upload vào bean staff
        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getName());
        }
        model.addAttribute("message", "Xin chào " + staff.getName());
        return "/lab4/create-staff";
    }
}
