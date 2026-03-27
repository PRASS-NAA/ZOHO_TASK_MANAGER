import java.time.LocalDate;

public class Task {
    private Long Id;

    private String Name;

    private String taskDescription;

    private LocalDate dueDate;

    Task(Long id, String name, String taskDescription, LocalDate dueDate){
        this.Id=id;
        this.Name=name;
        this.taskDescription=taskDescription;
        this.dueDate = dueDate;
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
}
