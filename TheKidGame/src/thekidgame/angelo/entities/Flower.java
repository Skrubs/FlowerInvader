package thekidgame.angelo.entities;

import java.util.ArrayList;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import thekidgame.angelo.game.GameTimer;
import thekidgame.angelo.util.Id;
import thekidgame.angelo.util.ImageLoader;

public class Flower extends Sprite {
	
	private int health;
	private static final int MAXHEALTH = 20;
	private int growthStage;
	private static final int MAX_GROWTH = 3;
	private boolean isPollinated;
	private double growthTimer;

	public Flower(Image spriteImage, double posX, double posY, double velX, double velY, Enum<Id> id) {
		super(spriteImage, posX, posY, velX, velY, id);
		health = MAXHEALTH;
		growthStage = 0;
		isPollinated = false;
		growthTimer = 0;
	}

	@Override
	public Rectangle2D getBounds() {
		return new Rectangle2D(this.getPosX()+5, this.getPosY()+5,this.getWidth()-5, this.getHeight()-5);
	}
	
	public void beingPollinated(Player player) {
		if(this.getBounds().intersects(player.pollinateBounds())) {
			isPollinated = true;
		}else {
			isPollinated = false;
			growthTimer = GameTimer.getTimer();
		}
		if(isPollinated == true) {
			if((GameTimer.getTimer() - growthTimer) > 5) {
				growthTimer = GameTimer.getTimer();
				if(growthStage + 1 <= 3) {
					growthStage++;
					System.out.println("My Growth Stage = " + growthStage);
				}
			}
		}
		this.setSpriteImage(flowerImage());
	}
	
	public Image flowerImage() {
		if(growthStage == 0) {
			return ImageLoader.FLOWER_BUD;
		}else if(growthStage == 1) {
			return ImageLoader.FLOWER_SPROUT;
		}else if(growthStage == 2) {
			return ImageLoader.FLOWER;
		}else {
			return ImageLoader.FLOWER;
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getGrowthStage() {
		return growthStage;
	}

	public void setGrowthStage(int growthStage) {
		this.growthStage = growthStage;
	}

	public boolean isPollinated() {
		return isPollinated;
	}

	public void setPollinated(boolean isPollinated) {
		this.isPollinated = isPollinated;
	}

	public static int getMaxhealth() {
		return MAXHEALTH;
	}

	public static int getMaxGrowth() {
		return MAX_GROWTH;
	}
	
	

}
