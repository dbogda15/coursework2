package task;

import java.time.LocalDate;
public class OneTimeTask extends Task {

    private final Integer id;
    public OneTimeTask(Type type, LocalDate dateTime, String title, String description) {
        super(type, dateTime, title, description);
        this.id = idGenerator;
    }

    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate dateTime) {
        return false;
    }

    @Override
    public String toString() {
        return "Onetime task. ID = " + id + ". Title: " +  getTitle() +
                "\n Description: " + getDescription() +
                "\n Date: " + getDateTime().getDayOfMonth() + " " + getDateTime().getMonth() + " " + getDateTime().getYear() +
                "\n Type of task: " + getType().getType() + "\n--------------------";
    }
}
