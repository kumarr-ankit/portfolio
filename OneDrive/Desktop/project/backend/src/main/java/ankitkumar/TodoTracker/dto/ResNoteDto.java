package ankitkumar.TodoTracker.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ResNoteDto {
    private String title,desc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dueAt;
    LocalDate createdAt;
    long id;
}
