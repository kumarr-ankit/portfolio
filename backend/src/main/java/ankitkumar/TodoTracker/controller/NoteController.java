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

import java.util.List;
import java.util.logging.Handler;

@AllArgsConstructor
@Controller
public class NoteController {

    @Autowired
    private final NoteService service;

    @GetMapping("/")
    public ResponseEntity<List<ResNoteDto>> getAllNotes(){

        return service.getAllNotes();
    }

    @GetMapping("/{id}")
    private  ResponseEntity<ResNoteDto> getNoteById(@PathVariable("id") Long id){
        return service.getById(id);
    }








}
