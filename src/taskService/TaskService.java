package taskService;

import exceptions.TaskNotFoundException;
import task.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TaskService {
    public static final String DATE_FORMATTER = "dd.MM.yyyy";
    private final static HashMap<Integer, Task> taskHashMap = new HashMap<>();

    public static HashMap<Integer, Task> getTaskHashMap() {
        return taskHashMap;
    }

    static Set<Task> removedTasks = new HashSet<>();

    public static void printMenu() {
        System.out.println("1. Add a task\n2. Remove a task\n3. Get a task for the specified day\n4. Check the trash can\n5. Get all tasks\n0. Exit");
    }

    public static void add(Task task){
        getTaskHashMap().put(task.getId(), task);
    }

    public static void inputTask(Scanner scanner) {
        Type taskType;

        System.out.print("Choose the type of your task:" +
                "\n1. work" +
                "\n2. personal" + "\n");
        int taskTypeInt = scanner.nextInt();
        if (taskTypeInt == 1) {
            taskType = Type.WORK;
        } else if (taskTypeInt == 2) {
            taskType = Type.PERSONAL;
        } else {
            System.out.println("*unavailable type of task*");
            taskType = Type.PERSONAL;
        }

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter the title of your task: ");
        String taskName = scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Enter the description of your task: ");
        String taskDescription = scanner2.nextLine();

        Scanner scanner3 = new Scanner(System.in);
        System.out.print("Please, enter the date in the format dd.MM.yyyy :");
        String date = scanner3.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        LocalDate parse = LocalDate.parse(date, formatter);

        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Please, choose the repeatability of your task:" +
                "\n 1. one time task" + "\n 2. daily task " + "\n 3. weekly task" +
                "\n 4. monthly task" + "\n 5. yearly task");

        int repeatability = scanner4.nextInt();
        switch (repeatability) {
            case 1:
                add(new OneTimeTask(taskType, parse, taskName, taskDescription));
                break;
            case 2:
                add(new DailyTask(taskType, parse, taskName, taskDescription));
                break;
            case 3:
                add(new WeeklyTask(taskType, parse, taskName, taskDescription));
                break;
            case 4:
                add(new MonthlyTask(taskType, parse, taskName, taskDescription));
                break;
            case 5:
                add(new YearlyTask(taskType, parse, taskName, taskDescription));
                break;
            default: {
                System.out.println("Please, enter the number from 1 to 5!!!");
            }
        }

        System.out.println("A new task has been created.");

    }

    public static LocalDate inputDate() {
        Scanner scanner5 = new Scanner(System.in);
        System.out.print("Please, enter the date in the format dd.MM.yyyy :");
        String date = scanner5.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        return LocalDate.parse(date, formatter);
    }


    public static void getAllByDate (HashMap<Integer, Task> taskHashMap, LocalDate date) {
        int i = 0;
        System.out.println("The list of tasks for  " + date.getDayOfMonth() + " " + date.getMonth() + " " + date.getYear() + ": \n");
        for (Map.Entry<Integer, Task> task : taskHashMap.entrySet()) {
            LocalDate taskDate = task.getValue().getDateTime();
            if (taskDate.equals(date) || task.getValue().appearsIn(date)) {
                i++;
                System.out.println(" " + task.getValue());
            }
        }
        if (i < 1) System.out.println("not found");
    }


    public static void remove () {
        Scanner scanner6 = new Scanner(System.in);
        System.out.print("Enter the unique number (ID) of the task you want to delete: ");
        Integer id = scanner6.nextInt() - 1;

        try {
            checkInputId(getTaskHashMap(), id);
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage() + id );
        }

        Task removedTask = getTaskHashMap().get(id);
        removedTasks.add(removedTask);
        getTaskHashMap().remove(id);
    }

    public static void getRemovedTasks() {
        if (removedTasks.size() > 0) {
            System.out.println("Deleted tasks: ");
            for (Task next : removedTasks) {
                System.out.println(next);
            }
        } else System.out.println("The trash can is empty!");
    }

    public static void checkInputId(Map<Integer, Task> tasks, int id) throws TaskNotFoundException {
        if (!tasks.containsKey(id)) {
            throw new TaskNotFoundException("There is no task with ID = ");
        }
    }

    public static void getAllTasks (){
        System.out.println("The list of all existing tasks: \n");
        for (Map.Entry<Integer, Task> task : getTaskHashMap().entrySet()) {
            System.out.println(" " + task.getValue());
        }
    }
}
