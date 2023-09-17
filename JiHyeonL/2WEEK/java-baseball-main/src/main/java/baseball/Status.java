package baseball;

public enum Status {
    CONTINUE("1"),
    EXIT("2");
    private String value;

    Status(String value) { this.value = value; }

    public String getValue() {
        return value;
    }
}
