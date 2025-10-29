package ankitkumar.TodoTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import ankitkumar.TodoTracker.service.NoteService;

@Controller
public class home {
    @Autowired
    private NoteService service;

    @GetMapping("/")
    private String loadHome() {
        System.out.println("Loaded");
        return service.loadHome();
    }
}
