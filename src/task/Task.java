package task;

import exceptions.IncorrectArgumentException;
import exceptions.IncorrectDateException;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Task {
    public static int idGenerator;
    private String title;
    private final int id;
    private String description;
    private LocalDate dateTime;
    private final Type type;

    public Task(Type type, LocalDate dateTime, String title, String description) {

       try {
           checkTittle(title);
           this.title = title;
       } catch (IncorrectArgumentException e) {
           this.title = "You have to change this title!";
           System.out.println(e.getMessage());
       }

        this.id = idGenerator++;
        this.description = description;
        this.type = type;

        try {
            checkDate(dateTime);
            this.dateTime = dateTime;
        } catch (IncorrectDateException e) {
            this.dateTime = LocalDate.now();
            System.out.println(e.getMessage() + dateTime.getDayOfMonth() + " " + dateTime.getMonth() + " " + dateTime.getYear());
            System.out.println("This task will be created with today's date. ");
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

    protected static void checkDate(LocalDate dateTime) throws IncorrectDateException {
        if (dateTime.isBefore(LocalDate.now())) {
            throw new IncorrectDateException("IncorrectDateException! This task can't be created, " +
                    "because you entered the past time! ", dateTime);
        }
    }

    protected static void checkTittle(String title) throws IncorrectArgumentException {
        if (Objects.isNull(title) || title.isEmpty()) {
            throw new IncorrectArgumentException("IncorrectArgumentException! This task can't be created, " +
                    "because you entered an empty title!");
        }
    }

   public abstract boolean appearsIn(LocalDate date);

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


