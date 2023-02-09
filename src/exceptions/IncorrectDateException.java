package exceptions;

import java.time.LocalDate;

public class IncorrectDateException extends Exception {
    private final LocalDate dateTime;
    public IncorrectDateException (String message, LocalDate dateTime) {
        super(message);
        this.dateTime = dateTime;
    }

    public LocalDate getDatetime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "IncorrectDateException! Please, change your dateTime! " + getDatetime().getYear();
    }
}
