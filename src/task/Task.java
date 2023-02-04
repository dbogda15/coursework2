package task;

import exceptions.IncorrectArgumentException;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Task {
    public static int idGenerator;
    private String title;
    private final int id;
    private String description;
    private final LocalDate dateTime;
    private final Type type;

    public Task(Type type, LocalDate dateTime, String title, String description) {
        this.title = title;
        this.id = idGenerator++;
        this.description = description;
        //this.dateTime = dateTime;
        this.type = type;

        try {
            checkDate(dateTime);
            this.dateTime = dateTime;
        } catch (IncorrectArgumentException e) {
            System.out.println(e.getMessage() + dateTime.getYear());
            throw new IllegalArgumentException();
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public Type getType() {
        return type;
    }

    protected static void checkDate(LocalDate dateTime) throws IncorrectArgumentException {
        if (dateTime.getYear() < LocalDate.now().getYear()) {
            throw new IncorrectArgumentException("IncorrectArgumentException! This task can't be created, because you entered the past time: ", dateTime);
        }
    }

   public abstract boolean appearsIn(LocalDate inputDate, LocalDate dateTime);


    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(dateTime, task.dateTime) && type == task.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, id, description, dateTime, type);
    }
}


