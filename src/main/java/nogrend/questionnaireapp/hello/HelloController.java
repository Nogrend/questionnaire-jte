package nogrend.questionnaireapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String view(Model model) {
        model.addAttribute("model", new DemoModel("Hello World"));
        return "aloha";
    }

}
