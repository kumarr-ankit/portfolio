package ankitkumar.TodoTracker.mapper;

import ankitkumar.TodoTracker.dto.ReqNoteDto;
import ankitkumar.TodoTracker.dto.ResNoteDto;
import ankitkumar.TodoTracker.entity.NoteEntity;

import java.time.LocalDate;

public class NoteMapper {


    public ResNoteDto toResNoteDto(NoteEntity e) {
        ResNoteDto resNoteDto = new ResNoteDto();
        resNoteDto.setTitle(e.getTitle());
        resNoteDto.setDesc(e.getDesc());
        resNoteDto.setCreatedAt(e.getCreatedAt());
        resNoteDto.setDueAt(e.getDueAt());
        resNoteDto.setId(e.getId());
        return resNoteDto;
    }

    public NoteEntity toEntity(ReqNoteDto res) {
        NoteEntity entity = new NoteEntity();

        LocalDate date = LocalDate.now();

        entity.setTitle(res.getTitle());
        entity.setDesc(res.getDesc());
        entity.setCreatedAt(date);
        try {
            System.out.println(res.getDueAt());
         if(!res.getDueAt().isEmpty()){
             entity.setDueAt(LocalDate.parse(res.getDueAt()));
         }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }


        return entity;
    }
}
