package thekidgame.angelo.menu;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import thekidgame.angelo.Main;
import thekidgame.angelo.game.GameScene;
import thekidgame.angelo.util.ImageLoader;

public class MainMenu {
	
	private static Group root;
	private static Scene menuScene;
	private static Canvas canvas;
	private static GraphicsContext gc;
	private static Button playButton;
	private static final double LAUNCHERWIDTH = 800;
	private static final double LAUNCHERHEIGHT = 600;

	private static GameScene gameScene;
	
	
	
	
	public MainMenu() {
	
	}
	
	public static Scene getMainMenuScene(String style) {
		
		root = new Group();
		menuScene = new Scene(root, LAUNCHERWIDTH, LAUNCHERHEIGHT);
		menuScene.getStylesheets().add(style);
		canvas = new Canvas(menuScene.getWidth(),menuScene.getHeight());
		gc = canvas.getGraphicsContext2D();
		
		gc.drawImage(ImageLoader.menuBackground, -100, -100);
		
		gameScene = new GameScene();
			
			
		playButton = new Button("Play");
		playButton.setId("playButton");
		playButton.setOnAction(e->{
			Main.getWindow().setScene(gameScene.getGameScene());
			Main.getWindow().setMaximized(true);
			Main.getWindow().setX(0);
			Main.getWindow().setY(0);
		
		});
		
		root.getChildren().addAll(canvas,playButton);
		return menuScene;
	}

}
