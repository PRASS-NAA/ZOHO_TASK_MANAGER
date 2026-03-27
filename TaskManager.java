
import java.util.List;
import java.util.Optional;


public class TaskManager
{
    List<Task> tasks;

    private TaskManager(List<Task> tasks)
    {
        this.tasks=tasks;
    }

    public static TaskManager creaTaskManager(List<Task> tasks)
    {
        return new TaskManager(tasks);
    }
    

    Boolean addTask(Task task)
    {
        return tasks.add(task);
    }

    Boolean removeTask(Long taskId)
    {
        Optional <Task> present = tasks.stream().filter(s -> s.getId() == taskId).findFirst();

        if(present.isEmpty())
        {
            System.out.println("Invalid id");
            return false;
        }else{
            tasks.remove(present.get());
            return true;
        }

        
    }

    List<Task> getTasks()
    {
        return tasks;
    }
}