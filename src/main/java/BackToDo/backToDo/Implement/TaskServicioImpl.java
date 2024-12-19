package BackToDo.backToDo.Implement;

import BackToDo.backToDo.Modelo.Task;
import BackToDo.backToDo.Respositorio.TaskRepositorio;
import BackToDo.backToDo.Servicio.TaskServicio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServicioImpl implements TaskServicio {

    //conexion de repositorio con los servicios jpa
    private final TaskRepositorio taskRepositorio;

    public TaskServicioImpl(TaskRepositorio taskRepositorio) {
        this.taskRepositorio = taskRepositorio;
    }

    @Override
    public List<Task> GetAllTasks() {
        return taskRepositorio.findAll();

    }

    @Override
    public Task PostTask(Task task) {

        return taskRepositorio.save(task);
    }

    @Override
    public Optional<Task> PutTask(Long id, Task task)
    {
       return taskRepositorio.findById(id).map(existingTask -> {
        existingTask.setNombre(task.getNombre());
        existingTask.setFechaInicio(task.getFechaInicio());
        existingTask.setEstatus(task.getEstatus());
        return taskRepositorio.save(existingTask);
       });
    }

    @Override
    public boolean DeleteTask(Long id) {
        if (taskRepositorio.existsById(id)) {
            taskRepositorio.deleteById(id);
            return true;
        }
        return false;
    }
}
