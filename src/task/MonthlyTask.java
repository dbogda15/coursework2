package task;

import java.time.LocalDate;
import java.util.Objects;

public class MonthlyTask extends Task{
    private final Integer id;
    public MonthlyTask(Type type, LocalDate dateTime, String title, String description) {
        super(type, dateTime, title, description);
        this.id = idGenerator;
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return Objects.equals(getDateTime().getDayOfMonth(), date.getDayOfMonth());
    }

    @Override
    public String toString() {
        return  "Monthly task. ID = "  + id + ". Title: " + getTitle() +
                "\n Description: " + getDescription() +
                "\n Date: " + getDateTime().getDayOfMonth() + " " + getDateTime().getMonth() +
                "\n Type of task: " + getType().getType() + "\n--------------------";
    }
}
