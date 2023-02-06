package task;

import java.time.LocalDate;

public class WeeklyTask extends Task{
    private final Integer id;
    public WeeklyTask(Type type, LocalDate dateTime, String title, String description) {
        super(type, dateTime, title, description);
        this.id = idGenerator;
    }

    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate dateTime) {
        return inputDate.getDayOfWeek() == dateTime.getDayOfWeek();
    }

    @Override
    public String toString() {
        return  "Weekly task. ID = " + id + ". Title: " + getTitle() +
                "\n Description: " + getDescription() +
                "\n Date: every " + getDateTime().getDayOfWeek() +
                "\n Type of task: " + getType().getType() + "\n--------------------";
    }
}
