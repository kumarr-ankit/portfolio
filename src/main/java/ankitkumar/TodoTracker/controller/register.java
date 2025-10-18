package ankitkumar.TodoTracker.controller;

import ankitkumar.TodoTracker.dto.ReqNoteDto;
import ankitkumar.TodoTracker.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class register {
    @Autowired
    private NoteService service;
    @PostMapping("/register")
    private ResponseEntity<String> addNote(@RequestBody ReqNoteDto rq){
      return service.addNote(rq);
    }
}
