package task;

public enum Type {
    WORK("work"),
    PERSONAL("personal");
    private final String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
