package thekidgame.angelo.entities;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import thekidgame.angelo.util.Id;

public abstract class Sprite {
	
	
	private double posX;
	private double posY;
	private double velX;
	private double velY;
	private double width;
	private double height;
	private Enum<Id> id;
	private Image spriteImage;
	private boolean isAlive;
	
	
	public Sprite(Image spriteImage,double posX, double posY, double velX, double velY, Enum<Id> id) {
		setSpriteImage(spriteImage);
		this.posX = posX;
		this.posY = posY;
		this.velX = velX;
		this.velY = velY;
		setSize(spriteImage);
		isAlive = true;
		this.id = id;
		
		
	}
	
	/**
	 * Draw Debug mode traces bounding box for collision debug
	 * @param gc
	 */
	public void debugDraw(GraphicsContext gc) {
		double x = this.getBounds().getMinX();
		double y = this.getBounds().getMinY();
		double w = this.getBounds().getMaxX() - x;
		double h = this.getBounds().getMaxY() - y;
		gc.strokeRect(x, y, w, h);
	}
	
	
	/**
	 * Set the width and height of the sprite based on the Image size
	 * @param spriteImage
	 */
	public void setSize(Image spriteImage) {
		if(spriteImage != null) {
			width = spriteImage.getWidth();
		}else {
			width = 20;
		}
		if(spriteImage != null) {
			height = spriteImage.getHeight();
		}else {
			height = 10;
		}
	}
	
	/**
	 * moves the sprite
	 */
	public void move() {
		posX += velX;
		posY += velY;
	}
	
	/**
	 * moves the sprite takes in a x and y
	 * @param velX
	 * @param velY
	 */
	public void move(double velX, double velY) {
		posX += velX;
		posY += velY;
	}
	
	/**
	 * move sprite on the x axis
	 * @param velX
	 */
	public void xMove(double velX) {
		posX += velX;
	}
	
	/**
	 * move sprite on the y axis
	 * @param velY
	 */
	public void yMove(double velY) {
		posY += velY;
	}
	
	/**
	 * gets the bounding box for the object
	 * @return
	 */
	public abstract Rectangle2D getBounds();
	
	/**
	 * checks collision between two sprites
	 * @param s
	 * @return boolean
	 */
	public boolean collision(Sprite s) {
		return this.getBounds().intersects(s.getBounds());
	}
	
	/**
	 * Checks collision between sprite and a rectangle
	 * @param r
	 * @return boolean
	 */
	public boolean objectCollision(Rectangle2D r) {
		return this.getBounds().intersects(r);
	}
	
	//SETTERS AND GETTERS BEYOND THIS POINT


	public double getPosX() {
		return posX;
	}


	public void setPosX(double posX) {
		this.posX = posX;
	}


	public double getPosY() {
		return posY;
	}


	public void setPosY(double posY) {
		this.posY = posY;
	}


	public double getVelX() {
		return velX;
	}


	public void setVelX(double velX) {
		this.velX = velX;
	}


	public double getVelY() {
		return velY;
	}


	public void setVelY(double velY) {
		this.velY = velY;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public Enum<Id> getId() {
		return id;
	}


	public void setId(Enum<Id> id) {
		this.id = id;
	}


	public Image getSpriteImage() {
		return spriteImage;
	}


	public void setSpriteImage(Image spriteImage) {
		if(spriteImage != null) {
			this.spriteImage = spriteImage;
		}else {
			this.spriteImage = new Image(getClass().getResource("textures/missingimage.png").toExternalForm());
		}
		
	}


	public boolean isAlive() {
		return isAlive;
	}


	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	
	
	

}
