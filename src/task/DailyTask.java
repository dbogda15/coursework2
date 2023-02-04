package task;

import java.time.LocalDate;

public class DailyTask extends Task {
    private final Integer id;
    public DailyTask(Type type, LocalDate dateTime, String title, String description) {
        super(type, dateTime, title, description);
        this.id = idGenerator;
    }

    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate dateTime) {
        return true;
    }

    @Override
    public String toString() {
        return  "Daily task №"  + id + ". Title: "+ getTitle() +
                "\n Description: " + getDescription() +
                "\n Type of task: " + getType().getType() + "\n--------------------";

    }
}
