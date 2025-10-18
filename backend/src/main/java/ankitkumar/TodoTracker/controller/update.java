package ankitkumar.TodoTracker.controller;

import ankitkumar.TodoTracker.dto.ReqNoteDto;
import ankitkumar.TodoTracker.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://127.0.0.1:5500/")
@RestController
public class update {
    @Autowired
    private NoteService service;
    @PatchMapping("/update")
    private String updateNote(@RequestBody ReqNoteDto br,@RequestParam("id") long id){

        return service.update(br,id);
    }
}
