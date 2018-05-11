package thekidgame.angelo.game;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import thekidgame.angelo.Main;

public class GameScene {
	
	
	private Group root;
	private static Scene gameScene;
	private Canvas canvas;
	private GraphicsContext gc;
	private GameTimer gameTimer;
	
	
	public GameScene() {
		initializeScene();
	}
	
	public void initializeScene() {
		root = new Group();
		gameScene = new Scene(root, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
		canvas = new Canvas(gameScene.getWidth(), gameScene.getHeight());
		gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		gameTimer = new GameTimer(this);
		gameTimer.start();
	}

	public Group getRoot() {
		return root;
	}

	public static Scene getGameScene() {
		return gameScene;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public GraphicsContext getGc() {
		return gc;
	}
	
	

}
