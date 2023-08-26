package Week1.onboarding;

import java.util.List;

class Problem1 {
    static Validation validation= new Validation();
    static PlayGame playGame = new PlayGame();

    public int solution(List<Integer> Crong, List<Integer> Pobi){
        if(validation.check(Crong) && validation.check(Pobi)){
            return playGame.battle(Crong, Pobi);
        }else{
            return -1;
        }
    }

    // 외부 클래스를 참조할 일이 없으면 내부 클래스는 static 선언을 하자.
    // Inner class
    static class Validation {
        private final int START_PAGE = 0;
        private final int END_PAGE = 400;

        public boolean check(List<Integer> PlayerPages){
            return checkIfNotNull(PlayerPages) && checkIfOdd(PlayerPages.get(0)) && checkIfOdd(PlayerPages.get(1)) && pageExistCheck(PlayerPages);
        }

        public boolean checkIfNotNull(List<Integer> PlayerPages){
            if(PlayerPages.get(0) != null && PlayerPages.get(1) != null)
                return true;

            return false;
        }

        public boolean checkIfOdd(int page){
            if(page % 2 == 1)
                return true;

            return false;
        }

        public boolean checkIfEven(int page){
            if(page % 2 == 0)
                return true;

            return false;
        }

        public boolean pageExistCheck(List<Integer> PlayerPages){
            if(PlayerPages.get(0) != START_PAGE & PlayerPages.get(0) != END_PAGE
                    && PlayerPages.get(1) != START_PAGE && PlayerPages.get(1) != END_PAGE){
                return true;
            }else
                return false;
        }
    }

    static class PlayGame{ ;
        public int battle(List<Integer> Crong, List<Integer> Pobi){
            int crongPoint =  calculateMaxPoint(Crong);
            int pobiPoint = calculateMaxPoint(Pobi);

            if(crongPoint < pobiPoint)
                return 1;
            else if(crongPoint > pobiPoint)
                return 2;
            else if(crongPoint == pobiPoint)
                return 0;
            else
                return -1;
        }

        public int calculateMaxPoint(List<Integer> Player){
            int page1 = Player.get(0);
            int page2 = Player.get(1);

            int sum1 = 0;
            int sum2 = 0;
            while(page1 > 0){
                int digit = page1 % 10;
                sum1 += digit;
                page1 /= 10;
            }

            while(page2 > 0){
                int digit = page2 % 10;
                sum2 += digit;
                page2 /= 10;
            }

            return Math.max(sum1, sum2);
        }
    }
}
