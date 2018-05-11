package thekidgame.angelo.util;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class ImageLoader {

	public static Image missingImage = new Image("textures/missingimage.png");
	public static Image menuBackground = new Image("textures/MenuBackground.png");
	public static Image background = new Image("textures/BackGround.png");

	private static Image spriteSheet = new Image("textures/Spritesheet.png");

	public static final WritableImage BEE1 = new WritableImage(spriteSheet.getPixelReader(),0,0,32,32);
	public static final WritableImage BEE2 = new WritableImage(spriteSheet.getPixelReader(),32,0,32,32);
	public static final WritableImage BEE3 = new WritableImage(spriteSheet.getPixelReader(),64,0,32,32);
	public static final WritableImage BEE4 = new WritableImage(spriteSheet.getPixelReader(),96,0,32,32);
	public static final WritableImage BEE5 = new WritableImage(spriteSheet.getPixelReader(),128,0,32,32);
	public static final WritableImage BEE6 = new WritableImage(spriteSheet.getPixelReader(),160,0,32,32);
	public static final WritableImage BEE7 = new WritableImage(spriteSheet.getPixelReader(),192,0,32,32);
	public static final WritableImage BEE8 = new WritableImage(spriteSheet.getPixelReader(),224,0,32,32);
	
	
	private static Image spriteSheetScaled = new Image("textures/spriteSheetScaled.png");
	
	public static final WritableImage BEEs1 = new WritableImage(spriteSheetScaled.getPixelReader(),0,0,64,64);
	public static final WritableImage BEEs2 = new WritableImage(spriteSheetScaled.getPixelReader(),64,0,64,64);
	public static final WritableImage BEEs3 = new WritableImage(spriteSheetScaled.getPixelReader(),128,0,64,64);
	public static final WritableImage BEEs4 = new WritableImage(spriteSheetScaled.getPixelReader(),192,0,64,64);
	public static final WritableImage BEEs5 = new WritableImage(spriteSheetScaled.getPixelReader(),256,0,64,64);
	public static final WritableImage BEEs6 = new WritableImage(spriteSheetScaled.getPixelReader(),320,0,64,64);
	public static final WritableImage BEEs7 = new WritableImage(spriteSheetScaled.getPixelReader(),384,0,64,64);
	public static final WritableImage BEEs8 = new WritableImage(spriteSheetScaled.getPixelReader(),448,0,64,64);
	
	private static Image flowerSheet = new Image("textures/flowerSheet.png");
	
	public static final WritableImage FLOWER_BUD = new WritableImage(flowerSheet.getPixelReader(), 256, 0 , 128, 128);
	public static final WritableImage FLOWER_SPROUT = new WritableImage(flowerSheet.getPixelReader(), 128, 0, 128, 128);
	public static final WritableImage FLOWER = new WritableImage(flowerSheet.getPixelReader(), 0, 0, 128, 128);
	
	

	
	public ImageLoader() {

	}
	
	

}
