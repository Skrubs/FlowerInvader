package thekidgame.angelo.game;

import javafx.animation.AnimationTimer;

public class GameTimer extends AnimationTimer {
	
	private GameScene gameScene;
	private Game game;
	private static double timer;
	private long startTime = System.nanoTime();
	
	public GameTimer(GameScene gameScene) {
		
		this.gameScene = gameScene;
		
		//initialize Game
		game = new Game();
		game.initializeGameObjects();
		
	}
	
	@Override
	public void handle(long now) {
		
		timer = (now - startTime) / 1000000000.0;
		
		game.update();
		game.render(gameScene.getGc());
	}
	
	public static double getTimer() {
		return timer;
	}
	
	

}
