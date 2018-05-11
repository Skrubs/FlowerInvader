package thekidgame.angelo.entities;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import thekidgame.angelo.Main;
import thekidgame.angelo.game.GameTimer;
import thekidgame.angelo.util.EntityAnimation;
import thekidgame.angelo.util.Id;
import thekidgame.angelo.util.ImageLoader;
import thekidgame.angelo.util.Movement;

public class EntityHandler {

	private ArrayList<Sprite> spriteList = new ArrayList<>();
	private Player player;
	private double temp = 0;
	private double now = 0;
	private Movement move;
	private int numOfFlowers = 0;
	private Random gen;

	public EntityHandler() {
		player = new Player(ImageLoader.missingImage, 400, 400, 0, 0, Id.player);
		player.loadImageArray();

		move = new Movement();
		gen = new Random();
	}

	public void addSprites() {

		if (!spriteList.contains(player)) {
			if (player != null) {
				spriteList.add(player);
			}
		}

		for (Sprite s : spriteList) {
			if (s.getId() == Id.flower) {
				numOfFlowers++;
			}
		}
		while (numOfFlowers < 10) {
			double x = gen.nextInt((int) Main.WINDOW_WIDTH - 55);
			double y = gen.nextInt((int) Main.WINDOW_HEIGHT - 300);
			spriteList.add(new Flower(ImageLoader.FLOWER_BUD, x, y, 0, 0, Id.flower));
			numOfFlowers++;
		}
		numOfFlowers = 0;
	}

	/**
	 * entity update
	 */
	public void update() {

		// add sprites
		addSprites();

		// update Movement
		move.move();

		// move player
		player.movePlayer(move);

		// pollinate flower
		for (Sprite s : spriteList) {
			if (s.getId() == Id.flower) {
				Flower f = (Flower) s;
				if(f.getGrowthStage() < 2) {
					player.pollinate(s);
				}
				f.beingPollinated(player);

			}
		}
		
		// flower being pollinated check

	}

	/**
	 * render entities
	 */
	public void render(GraphicsContext gc) {

		// draw flowers
		for (Sprite s : spriteList) {
			if (s.getId() == Id.flower) {
				gc.drawImage(s.getSpriteImage(), s.getPosX(), s.getPosY());

			}
		}

		// draw player
		drawPlayer(gc, .05);

	}

	public void drawPlayer(GraphicsContext gc, double duration) {

		if (player.getLanded() == false) {
			double t = GameTimer.getTimer();
			if (player.getVelX() == 0 && player.getVelY() == 0) {

				gc.drawImage(EntityAnimation.getImage(player.getDownAnimation(), t, duration), player.getPosX(),
						player.getPosY());

			} else if (player.getVelX() > 0) {
				gc.drawImage(EntityAnimation.getImage(player.getRightAnimation(), t, duration), player.getPosX(),
						player.getPosY());
			} else if (player.getVelX() < 0) {
				gc.drawImage(EntityAnimation.getImage(player.getLeftAnimation(), t, duration), player.getPosX(),
						player.getPosY());
			} else if (player.getVelY() > 0) {
				gc.drawImage(EntityAnimation.getImage(player.getDownAnimation(), t, duration), player.getPosX(),
						player.getPosY());
			} else if (player.getVelY() < 0) {
				gc.drawImage(EntityAnimation.getImage(player.getUpAnimation(), t, duration), player.getPosX(),
						player.getPosY());
			}
		}else if(player.getLanded() == true) {
			gc.fillRect(player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight());
		}
		
		
	}

	public Player getPlayer() {
		return player;
	}
}
