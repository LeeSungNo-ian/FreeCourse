package Week1.onboarding;

public class Problem3 {

    static Game game = new Game();
    public static int solution(int number){
        return game.start(number);
    }

    static class Game{
        public int start(int number){
            int result = 0;
            for(int i=1; i<=number; i++){
                int temp_number = i;
                while(temp_number > 0){
                    int digit = temp_number % 10;
                    if(digit == 3 || digit == 6 || digit == 9){
                        result++;
                    }
                    digit /= 10;
                }
            }
            return result;
        }
    }
}
