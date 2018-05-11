package thekidgame.angelo.game;

import javafx.scene.canvas.GraphicsContext;
import thekidgame.angelo.entities.EntityHandler;
import thekidgame.angelo.screenInformation.Hud;
import thekidgame.angelo.util.ImageLoader;

public class Game {
	
	
	
	private Handler handler;
	private EntityHandler entityHandler;
	private Hud hud;
	
	
	public Game() {
		
	}
	
	/**
	 * Initialize all Game Objects and register them to the game.
	 */
	public void initializeGameObjects() {
		handler = new Handler(this);
		entityHandler = new EntityHandler();
		hud = new Hud();
	}
	
	/**
	 * updates gameObjects
	 */
	public void update() {
		//update entities
		entityHandler.update();
		
		//update hud
		hud.update(entityHandler.getPlayer().getHealth(), 300);
	}
	
	/**
	 * Renders all objects to the screen
	 */
	public void render(GraphicsContext gc) {
		
		//background
		gc.drawImage(ImageLoader.background, 0, -935);
		
		//render entities
		entityHandler.render(gc);
		
		//draw hud
		hud.loadHud(gc);
		
		
	
	}

}
