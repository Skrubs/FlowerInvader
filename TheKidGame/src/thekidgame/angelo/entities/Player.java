package thekidgame.angelo.entities;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import thekidgame.angelo.Main;
import thekidgame.angelo.game.GameScene;
import thekidgame.angelo.game.GameTimer;
import thekidgame.angelo.util.Id;
import thekidgame.angelo.util.ImageLoader;
import thekidgame.angelo.util.Movement;

public class Player extends Sprite {

	private Image[] downAnimation;
	private Image[] leftAnimation;
	private Image[] rightAnimation;
	private Image[] upAnimation;
	private int health = 40;
	private final int MAXHEALTH = 100;
	private double lastHealed = 0;
	private boolean landed;

	public Player(Image spriteImage, double posX, double posY, double velX, double velY, Enum<Id> id) {
		super(spriteImage, posX, posY, velX, velY, id);
		setSize(spriteImage);
		landed = false;

	}

	@Override
	public void setSize(Image spriteImage) {
		if (spriteImage != null) {
			this.setWidth(spriteImage.getWidth() + 30);
		} else {
			this.setWidth(20);
		}
		if (spriteImage != null) {
			this.setHeight(spriteImage.getHeight() + 30);
		} else {
			this.setHeight(30);
		}
	}

	@Override
	public Rectangle2D getBounds() {
		return new Rectangle2D(this.getPosX() + 5, this.getPosY() + 5, this.getWidth() - 10, this.getHeight() - 10);
	}

	public Rectangle2D pollinateBounds() {
		double centerX = (this.getBounds().getMinX() + 18);
		double centerY = (this.getBounds().getMinY() + 5);
		return new Rectangle2D(centerX, centerY, 10, 20);
	}

	public void pollinate(Sprite s) {
		if (this.pollinateBounds().intersects(s.getBounds())) {
			if (this.health < this.MAXHEALTH && (GameTimer.getTimer() - lastHealed) > 1) {
				health++;
				lastHealed = GameTimer.getTimer();
			}
		}
	}

	public void playerImage() {

	}

	public void loadImageArray() {
		downAnimation = new Image[2];
		downAnimation[0] = ImageLoader.BEEs1;
		downAnimation[1] = ImageLoader.BEEs2;
		rightAnimation = new Image[2];
		rightAnimation[0] = ImageLoader.BEEs3;
		rightAnimation[1] = ImageLoader.BEEs4;
		upAnimation = new Image[2];
		upAnimation[0] = ImageLoader.BEEs5;
		upAnimation[1] = ImageLoader.BEEs6;
		leftAnimation = new Image[2];
		leftAnimation[0] = ImageLoader.BEEs7;
		leftAnimation[1] = ImageLoader.BEEs8;

	}

	public boolean getLanded() {
		return landed;
	}

	public void setLanded(boolean landed) {
		this.landed = landed;
	}

	public int getHealth() {
		return health;
	}

	public Image[] getDownAnimation() {
		return downAnimation;
	}

	public Image[] getLeftAnimation() {
		return leftAnimation;
	}

	public Image[] getRightAnimation() {
		return rightAnimation;
	}

	public Image[] getUpAnimation() {
		return upAnimation;
	}

	public void movePlayer(Movement move) {

		if (move.getInputList().contains("W")) {
			this.setVelY(-3);
		}
		if (move.getInputList().contains("S")) {
			this.setVelY(3);
		}
		if (move.getInputList().contains("D")) {
			this.setVelX(3);
		}
		if (move.getInputList().contains("A")) {
			this.setVelX(-3);
		}

		if (!move.getInputList().contains("W") && !move.getInputList().contains("S")) {
			this.setVelY(0);
		}
		if (!move.getInputList().contains("D") && !move.getInputList().contains("A")) {
			this.setVelX(0);
		}
		this.move();
	}

}
