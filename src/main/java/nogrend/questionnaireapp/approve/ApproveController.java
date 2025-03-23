package nogrend.questionnaireapp.approve;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApproveController {
    @GetMapping("/approve")
    public String index(Model model) {
        model.addAttribute("approver", new Approver());
        // model.addAttribute("formData", new HashMap<String, String>()); // todo find out if it's works without adding the object itself
        return "approve";
    }

    @PostMapping("/approve")
    public String submitApprove(@Valid Approver approver, BindingResult bindingResult, Model model) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("approver", approver);
                model.addAttribute("errors", bindingResult.getAllErrors());
                return "approve";
            }
        if (approver.hasApproved()) {
            System.out.println("Approved");
        } else {
            System.out.println("Rejected");
        }
        System.out.println(approver);

        model.addAttribute("message", "Thank you, " + approver.getName());
        return "approve";
    }
}
