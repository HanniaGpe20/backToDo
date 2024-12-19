package BackToDo.backToDo.Respositorio;

import BackToDo.backToDo.Modelo.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepositorio extends JpaRepository<Task, Long> {
}
