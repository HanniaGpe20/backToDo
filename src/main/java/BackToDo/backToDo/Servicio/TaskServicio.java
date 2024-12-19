package BackToDo.backToDo.Servicio;


import BackToDo.backToDo.Modelo.Task;

import java.util.List;
import java.util.Optional;

    //METODOS DEL SERVICIO
public interface TaskServicio {

    //Devuelve los registros en la lista
    List<Task> GetAllTasks();

    //Genera registro de tareas
    Task PostTask(Task task);

    //Actualiza tareas
    Optional<Task> PutTask(Long id, Task task);

    //Elimina Tareas
    boolean DeleteTask(Long id);
}
