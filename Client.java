import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
            System.out.println("enter 4 for Searching tasks");
            System.out.println("enter 5 for exit");
            System.out.println("Enter your choice : ");
            int inp = input.nextInt();

            switch (inp) {
                case 1:
                    System.out.println("enter task ID : ");
                    Long id = input.nextLong();
                    input.nextLine();
                    System.out.println("Enter Task Name : ");
                    String name = input.nextLine();
                    System.out.println("Enter Task description : ");
                    String descp = input.nextLine();
                    LocalDate formatedDate = null;
                    while(formatedDate == null)
                    {
                        System.out.println("Enter Due date (dd-mm-yyyy) : ");
                        String dueDate = input.nextLine();
                        formatedDate = dateFormat(dueDate);
                    }
                    Priority pri = null;;
                    while (pri == null) {
                        try {
                            System.out.println("Enter Task Priority (HIGH/MEDIUM/LOW) or press Enter for default:");
                            String inputStr = input.nextLine().trim();

                            if (inputStr.isEmpty()) {
                                break; // user wants default
                            }

                            pri = Priority.valueOf(inputStr.toUpperCase());

                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid priority! Please enter HIGH, MEDIUM, or LOW.");
                        }
                    }
                    
                    if(pri == null)
                    {
                        tm.addTask(new Task(id, name, descp, formatedDate));
                    }else{
                        tm.addTask(new Task(id, name, descp, formatedDate, pri));
                    }
                    System.out.println("Task added successfully");
                     break;
                case 2:
                    System.out.println("enter task ID to remove : ");
                    Long remId = input.nextLong();
                    boolean delete = tm.removeTask(remId);

                    String msg = (delete == true) ? "deleteion" : "delteion unsucessful"; 
                    
                    System.out.println(msg);
                    break;
                
                case 3:
                    List<Task> display=tm.getTasks();

                    display.stream().forEach(s->System.out.println("Task ID : " + s.getId()+" | " + "Task Name : " +s.getName() + " | " + " Task Description : "+ s.getDescription() + " | " + "Due Date : " + convertToStr(s.getDueDate()) + " | " + "Task Priority : " + s.getPriority()));

                    break;

                case 4:
                    System.out.println("enter 1 for search by priority");
                    while(true)
                    {
                        System.out.println("Enter the priority for searching tasks (HIGH/MEDIUM/LOW): ");

                        try{
                            String priVal = input.next().strip();

                            Priority prio = Priority.valueOf(priVal.toUpperCase());

                            SearchStrategy search = new SearchByPriority(prio);

                            search.search(tasks);

                            break;
                        }catch(IllegalArgumentException e)
                        {
                            System.out.println("enter Valid priority Values only !! ");
                        }
                    }   
                    
                    break;
                case 5:
                    System.exit(0);    

                default:
                    System.out.println("invalid Input");
                    break;
            }
        }
    }

    public static LocalDate dateFormat(String dueDate)
    {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = null;
        try{
            date = LocalDate.parse(dueDate, formatter);
            
            if(date.isBefore(LocalDate.now()))
            {
                System.out.println("date should not be before current date");
                return null;
            }

            

        }catch(DateTimeParseException e)
        {
            System.out.println("Please Enter Date in specified format !! ");
        }
        return date;
    }

    public static String convertToStr(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formatted = date.format(formatter);
        return formatted;
    }
}
