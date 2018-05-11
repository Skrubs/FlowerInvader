package thekidgame.angelo;
	
import javafx.application.Application;
import javafx.stage.Screen;
import javafx.stage.Stage;
import thekidgame.angelo.menu.MainMenu;
import thekidgame.angelo.util.ImageLoader;



public class Main extends Application {
	
	private static Stage window;
	public static final double WINDOW_WIDTH = Screen.getPrimary().getBounds().getWidth();
	public static final double WINDOW_HEIGHT = Screen.getPrimary().getBounds().getHeight();
	private String title = "KidGame v0.1";
	private String style = getClass().getResource("application.css").toExternalForm();
	
	
	@Override
	public void start(Stage primaryStage) {
		
		window = primaryStage;
		
		//LOAD IMAGELOADER
		//ImageLoader loader = new ImageLoader();
		
		window.setScene(MainMenu.getMainMenuScene(style));	
		window.sizeToScene();
		window.setResizable(true);
		window.setTitle(title);
		window.show();
	
	}
	
	public String getStyle() {
		return style;
	}
	
	public static Stage getWindow() {
		return window;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
