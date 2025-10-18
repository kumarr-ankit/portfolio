package ankitkumar.TodoTracker.controller;

import ankitkumar.TodoTracker.service.external_api_service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Background_Img_Controller {
public external_api_service service = new external_api_service();
    @GetMapping("/random")
    public String toString() {


        return "redirect:"+service.getRandomUrl();
    }
}
