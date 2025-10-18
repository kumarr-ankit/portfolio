package ankitkumar.TodoTracker.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReqNoteDto {

    private String title,desc;
    String dueAt;

}
