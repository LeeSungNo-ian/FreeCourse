package lotto.service;

import java.util.List;

public enum Rank {
    // 순위 별 당첨금
    FIRST_PRIZE(2000000000,"6개 일치 (2,000,000,000원) - "),
    SECOND_PRIZE(30000000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_PRIZE(1500000,"5개 일치 (1,500,000원) - "),
    FOURTH_PRIZE(50000,"4개 일치 (50,000원) - "),
    FIFTH_PRIZE(5000,"3개 일치 (5,000원) - ");

    private int value;
    private String description;

    Rank(int value, String description) {
        this.value = value;
        this.description = description;
    }

    /*
     * Rank enum description 리스트 반환
     */
    public static List<String> getDescriptionList() {
        return List.of(FIFTH_PRIZE.description, FOURTH_PRIZE.description, THIRD_PRIZE.description, SECOND_PRIZE.description, FIRST_PRIZE.description);
    }
    /*
     * Rank enum value 리스트 반환
     */
    public static List<Integer> getRankList() {
        return List.of(FIFTH_PRIZE.value, FOURTH_PRIZE.value, THIRD_PRIZE.value, SECOND_PRIZE.value, FIRST_PRIZE.value);
    }
    /*
     * 일치한 번호 count -> 순위-1 반환, count == 0이면 -1 반환
     */
    public static int getCountToRank(int count, int bonusCount) {
        if (count == 6)
            return 0;
        if (count == 5 && bonusCount == 1)
            return 1;
        if (count == 5)
            return 2;
        if (count == 4)
            return 3;
        if (count == 3)
            return 4;
        return -1;
    }
}
