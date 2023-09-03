package baseball;

public enum Hint {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");
    private String value;

    Hint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}