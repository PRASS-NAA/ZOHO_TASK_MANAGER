public class Task {
    private Long Id;

    private String Name;

    private String taskDescription;

    Task(Long id, String name, String taskDescription){
        this.Id=id;
        this.Name=name;
        this.taskDescription=taskDescription;

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
}
