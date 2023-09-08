package baseball;

public class GameController {

	private GameService gameService = new GameService();

	public void startGame() {
		gameService.start();
	}
}
