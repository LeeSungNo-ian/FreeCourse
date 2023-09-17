package baseball;

public enum Input {
    SIZE(3),
    START(1),
    END(9);
    private int value;

    Input(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
