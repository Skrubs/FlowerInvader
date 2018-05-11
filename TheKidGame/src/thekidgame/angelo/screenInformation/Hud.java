package thekidgame.angelo.screenInformation;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import thekidgame.angelo.Main;

public class Hud {
	
	private double healthAmount;
	private final double MAXHEALTH = 300;
	private double energyAmount;
	private final double MAXENERGY = 300;
	
	
	public Hud() {
		healthAmount = MAXHEALTH;
		energyAmount = MAXENERGY;
	}
	
	public void loadHud(GraphicsContext gc) {
		
		//Health bar information 
		Text text = new Text("Health");
		text.setLayoutX(200);
		text.setLayoutY(Main.WINDOW_HEIGHT-210);
		
		gc.setFont(Font.font(20));
		gc.strokeText(text.getText(), text.getLayoutX(), text.getLayoutY());
		gc.setFill(Color.WHITESMOKE);
		gc.setGlobalAlpha(.2);
		gc.fillRect(200,(Main.WINDOW_HEIGHT-200), 300 , 50);
		gc.setGlobalAlpha(1);
		gc.setFill(Color.RED);
		gc.fillRect(200, Main.WINDOW_HEIGHT-200, healthAmount, 50);
		gc.strokeText(healthAmount+"", 250, Main.WINDOW_HEIGHT-175);
		
		//Energy bar information
		Text text2 = new Text("Energy");
		text2.setLayoutX(Main.WINDOW_WIDTH-500);
		text2.setLayoutY(Main.WINDOW_HEIGHT-210);
		
		gc.setFont(Font.font(20));
		gc.strokeText(text2.getText(), text2.getLayoutX(), text2.getLayoutY());
		gc.setFill(Color.WHITESMOKE);
		gc.setGlobalAlpha(.2);
		gc.fillRect(Main.WINDOW_WIDTH-500,(Main.WINDOW_HEIGHT-200), 300 , 50);
		gc.setGlobalAlpha(1);
		gc.setFill(Color.BLUE);
		gc.fillRect(Main.WINDOW_WIDTH-500, Main.WINDOW_HEIGHT-200, energyAmount, 50);
		
	}
	
	public void update(double healthAmount, double energyAmount) {
		this.healthAmount = healthAmount;
		this.energyAmount = energyAmount;
	}
	
	public void updateHealth(double healthAmount) {
		this.healthAmount = healthAmount;
	}
	
	public void udpateEnergy(double energyAmount) {
		this.energyAmount = energyAmount;
	}

}
