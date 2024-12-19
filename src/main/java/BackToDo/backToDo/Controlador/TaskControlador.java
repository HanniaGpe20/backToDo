package BackToDo.backToDo.Controlador;


import BackToDo.backToDo.Modelo.Task;
import BackToDo.backToDo.Servicio.TaskServicio;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Tasks") //http://localhost:8080/Tasks dic de peticiones de la api
public class TaskControlador {

    private final TaskServicio taskServicio;

    public TaskControlador(TaskServicio taskServicio) {
        this.taskServicio = taskServicio;
    }

    @GetMapping
    public List<Task> GetAllTasks() {

        return taskServicio.GetAllTasks();
    }

   @PostMapping
   public ResponseEntity<?> postTask(@Valid @RequestBody Task task) {
       try {
           Task savedTask = taskServicio.PostTask(task);
           return ResponseEntity.ok(savedTask);
       } catch (Exception e) {
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
       }
   }


    @PutMapping("/{id}")
    public ResponseEntity<Task> PutTask(@PathVariable Long id, @RequestBody Task task) {
        Optional<Task> updatedTask = taskServicio.PutTask(id, task);
        return updatedTask.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteTask(@PathVariable Long id) {
        if (taskServicio.DeleteTask(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
