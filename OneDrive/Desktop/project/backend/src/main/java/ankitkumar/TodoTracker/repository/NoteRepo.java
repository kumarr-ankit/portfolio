package ankitkumar.TodoTracker.repository;

import ankitkumar.TodoTracker.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo extends JpaRepository<NoteEntity,Long> {
}
