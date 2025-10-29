package ankitkumar.TodoTracker.controller;

import ankitkumar.TodoTracker.dto.ReqNoteDto;
import ankitkumar.TodoTracker.dto.ResNoteDto;
import ankitkumar.TodoTracker.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

@AllArgsConstructor
@Controller
@CrossOrigin("*")
public class NoteController {

    @Autowired
    private final NoteService service;

    @GetMapping("/notes")
    private ResponseEntity<List<ResNoteDto>> getNoteById(@RequestParam(defaultValue = "0", name = "id") Long id) {
        System.out.println(id);
        if (id == 0) {

            return service.getAllNotes();
        }

        ResponseEntity<ResNoteDto> res = service.getById(id);

        List<ResNoteDto> list = new ArrayList<>();
        list.add(res.getBody());

        return ResponseEntity.status(res.getStatusCode()).body(list);
    }

}
