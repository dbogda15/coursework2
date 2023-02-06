import task.*;

import java.time.LocalDate;
import java.util.*;

import static taskService.TaskService.*;

public class Main {

    public static void main(String[] args) {

        Task task1 = new YearlyTask(Type.PERSONAL, LocalDate.of(2023, 2, 15), "Birthday", "I have to celebrate my birthday");
        Task task2 = new OneTimeTask(Type.WORK, LocalDate.of(2023, 2, 10), "Quite job", "This day is my last working day for my company");
        Task task3 = new WeeklyTask(Type.PERSONAL, LocalDate.of(2023,3,1),"Gym", "leg day!");
        Task task4 = new MonthlyTask(Type.WORK, LocalDate.of(2023,4,6), "salary", "day of the salary");
        Task task5 = new DailyTask(Type.PERSONAL, LocalDate.of(2023,2,10), "healthy food", "I have to make a healthy breakfast!");

        getTaskHashMap().put(task1.getId(), task1);
        getTaskHashMap().put(task2.getId(), task2);
        getTaskHashMap().put(task3.getId(), task3);
        getTaskHashMap().put(task4.getId(), task4);
        getTaskHashMap().put(task5.getId(), task5);

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Select a menu item: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            remove();
                            break;
                        case 3:
                            getAllByDate(getTaskHashMap(), inputDate());
                            break;
                        case 4:
                            getRemovedTasks();
                            break;
                        case 5:
                            getAllTasks();
                            break;
                        case 0:
                            break label;
                        default:
                            System.out.println("unknown menu item!");
                    }
                } else {
                   scanner.next();
                    System.out.println("Select a menu item from the list!");
                }
            }
        }
    }
}