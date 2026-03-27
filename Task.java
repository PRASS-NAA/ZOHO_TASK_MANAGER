public class Task {
    private Long Id;

    private String Name;

    Task(Long id, String name){
        Id=id;
        Name=name;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }
}
