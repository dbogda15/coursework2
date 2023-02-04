package exceptions;

import task.Task;

import java.time.LocalDate;

public class IncorrectArgumentException extends Exception {
    private final LocalDate dateTime;
    public IncorrectArgumentException (String message, LocalDate dateTime) {
        super(message);
        this.dateTime = dateTime;
    }

    public LocalDate getDatetime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "IncorrectArgumentException! Please, change your tittle! " + getDatetime().getYear();
    }
}
