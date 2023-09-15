package lotto.service;

public enum Info {
    LOTTO_UNIT(1000), //로또 한 장 가격
    COUNT_NUMBERS(6),   // 로또 한 장당 번호 개수
    START_NUMBER(1),    // 로또 가능한 최소 숫자
    END_NUMBER(45);     // 로또 가능한 최대 숫자
    private int value;

    Info(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
