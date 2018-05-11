package thekidgame.angelo.util;

import java.util.ArrayList;

import javafx.scene.image.Image;
import thekidgame.angelo.entities.Sprite;

public class EntityAnimation {
	
	
	
	
	
	public void EntityAnimation() {
		
	}

	
	public static Image getImage(Image[] imageArray, double timer, double d) {
		int index = (int) ((timer % (imageArray.length * d))/d);
		return imageArray[index];
	}
	
	

}
