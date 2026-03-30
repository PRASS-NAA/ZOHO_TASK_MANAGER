import java.time.LocalDate;

public class Task {
    private Long Id;

    private String Name;

    private String taskDescription;

    private LocalDate dueDate;

    private Priority priority;

    Task(Long id, String name, String taskDescription, LocalDate dueDate){
        this(id,name,taskDescription,dueDate,Priority.MEDIUM);
    }

    Task(Long id, String name, String taskDescription, LocalDate dueDate, Priority priority){
        this.Id=id;
        this.Name=name;
        this.taskDescription=taskDescription;
        this.dueDate = dueDate;
        this.priority=priority;
    }

    public Long getId() {
        return this.Id;
    }

    public String getName() {
        return this.Name;
    }
    public String getDescription()
    {
        return this.taskDescription;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public Priority getPriority()
    {
        return this.priority;
    }
}
