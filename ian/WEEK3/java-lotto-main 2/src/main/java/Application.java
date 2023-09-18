import static util.RandomNumberGeneratorUtil.randomNumbersGenerate;
import static view.InputView.readLottoPurchaseValidator;


public class Application {
    public static void main(String[] args) {
        readLottoPurchaseValidator();
        randomNumbersGenerate();
    }
}
