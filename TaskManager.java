
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
        return this.tasks.add(task);
    }

    Boolean removeTask(Long taskId)
    {
        Optional <Task> present = this.tasks.stream().filter(s -> s.getId() == taskId).findFirst();

        if(present.isEmpty())
        {
            System.out.println("Invalid id");
            return false;
        }else{
            this.tasks.remove(present.get());
            return true;
        }

        
    }

    List<Task> getTasks()
    {
        return this.tasks;
    }
}