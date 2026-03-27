import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        List<Task> tasks = new ArrayList<>();
        TaskManager tm = TaskManager.creaTaskManager(tasks);

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("enter 1 for adding task");
            System.out.println("enter 2 for removing task");
            System.out.println("enter 3 for display all tasks");
            System.out.println("enter 4 for exit");
            System.out.println("Enter your choice : ");
            int inp = input.nextInt();

            switch (inp) {
                case 1:
                    System.out.println("enter task ID : ");
                    Long id = input.nextLong();
                    input.nextLine();
                    System.out.println("Enter Task Name : ");
                    String name = input.nextLine();
                    tm.addTask(new Task(id, name));
                    System.out.println("Task added successfully");
                    break;
                case 2:
                    System.out.println("enter task ID to remove : ");
                    Long remId = input.nextLong();
                    boolean delete = tm.removeTask(remId);

                    String msg = (delete == true) ? "deleteion" : "delteion unsucessful"; 
                    
                    System.out.println(msg);
                
                    case 3:
                        List<Task> display=tm.getTasks();

                        display.stream().forEach(s->System.out.println("Task ID : " + s.getId()+" | " + "Task Name : " +s.getName()));

                        break;

                    case 4:
                        System.exit(0);    
                default:
                    System.out.println("invalid Input");
                    break;
            }
        }
    }
}
