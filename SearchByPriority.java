import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchByPriority implements SearchStrategy{

    private Priority pri;

    public SearchByPriority(Priority pri)
    {
        this.pri = pri;
    }
    
    
    public void search(List<Task> tasks) {
        List<Task> filteredTask = tasks.stream()
            .filter(t -> t.getPriority() == pri)
            .toList();

        if (filteredTask.isEmpty()) {
            System.out.println("No tasks found with the specified priority.");
        } else {
            filteredTask.forEach(e ->System.out.println("Task Name : " + e.getName() + " | Task Description : " + e.getDescription() + " | Due Date : " + e.getDueDate() +" | Task Priority : " + e.getPriority()));
        }
    }
}