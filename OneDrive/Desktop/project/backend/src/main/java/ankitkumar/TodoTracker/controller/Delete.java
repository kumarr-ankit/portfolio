package ankitkumar.TodoTracker.controller;

import ankitkumar.TodoTracker.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class Delete {
    @Autowired
   private NoteService service;
    @DeleteMapping("/del/{id}")
    private String deleteNote(@PathVariable("id") String id){

        return  service.delete(id);
        //Whole Day ..
    }

}
