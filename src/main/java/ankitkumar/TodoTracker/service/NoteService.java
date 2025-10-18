package ankitkumar.TodoTracker.service;

import ankitkumar.TodoTracker.dto.ReqNoteDto;
import ankitkumar.TodoTracker.dto.ResNoteDto;
import ankitkumar.TodoTracker.entity.NoteEntity;
import ankitkumar.TodoTracker.mapper.NoteMapper;
import ankitkumar.TodoTracker.repository.NoteRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class NoteService {

    @Autowired
    private NoteRepo noteRepo;
    NoteMapper noteMapper = new NoteMapper();
    public String delete(String id) {

        try {
            Long i = Long.parseLong(id);
            System.out.println(i);
            noteRepo.deleteById(i);
            return "Success";
        } catch (NumberFormatException e) {
            return e.getLocalizedMessage();
        }
    }

    public ResponseEntity<List<ResNoteDto>> getAllNotes() {
        List<ResNoteDto> resNoteDtos = new ArrayList<>();
        List<NoteEntity> entityList = noteRepo.findAll();
        entityList.forEach(e -> {
            resNoteDtos.add(noteMapper.toResNoteDto(e));
        });


        return ResponseEntity.status(HttpStatus.OK).body(resNoteDtos);
    }

    public ResponseEntity<ResNoteDto> getById(Long id) {
        NoteEntity noteEntity = noteRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("error occurred while finding todo with id : " + id));
        ResNoteDto resNoteDto = noteMapper.toResNoteDto(noteEntity);
        return ResponseEntity.status(HttpStatus.OK).body(resNoteDto);
    }

    public ResponseEntity<String> addNote(ReqNoteDto reqNoteDto) {
        //  System.out.println(reqNoteDto);
        NoteEntity entity = noteMapper.toEntity(reqNoteDto);

        System.out.println(entity);
        if(noteRepo != null && entity != null){
            NoteEntity e = noteRepo.save(entity);
            System.out.println(e);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Success ✅: " + reqNoteDto);

    }


    public String update(ReqNoteDto br,long id) {

//       try{

           NoteEntity entity = noteRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Error"));
           NoteEntity reqEntity = noteMapper.toEntity(br);

           if(reqEntity.getTitle().isEmpty() && reqEntity.getDueAt() == null && reqEntity.getDesc().isEmpty()) return "empty";


           if(reqEntity.getTitle() != null){
               entity.setTitle(reqEntity.getTitle());
           }
           if(reqEntity.getDueAt() != null){
               entity.setDueAt(reqEntity.getDueAt());
           }

           if(reqEntity.getDesc() != null){
               entity.setDesc(reqEntity.getDesc());
           }

           noteRepo.save(entity);


       return "Success";
//       }catch (RuntimeException e){
//         throw new RuntimeException(e.getMessage());
//       }
    }
}
