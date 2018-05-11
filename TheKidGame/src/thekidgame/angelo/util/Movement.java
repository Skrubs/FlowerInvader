package thekidgame.angelo.util;

import java.util.ArrayList;

import thekidgame.angelo.game.GameScene;

public class Movement {

	private ArrayList<String> inputList;
	private int fired = 0;

	public Movement() {
		inputList = new ArrayList<>();

	}

	public ArrayList<String> move() {
		GameScene.getGameScene().setOnKeyPressed(e -> {
			String code = e.getCode().toString();
			if (!inputList.contains(code)) {
				inputList.add(code);
			}
		});

		GameScene.getGameScene().setOnKeyReleased(e -> {
			String code = e.getCode().toString();
			if (inputList.contains(code)) {
				inputList.remove(code);
			}
		});
		return inputList;
	}

	public int fire() {
		GameScene.getGameScene().setOnMouseClicked(e -> {
			if (e.isPrimaryButtonDown()) {
				fired = 1;
			}
		});
		return fired;
	}
	
	public void setFired(int f) {
		fired = f;
	}

	public ArrayList<String> getInputList() {
		return inputList;
	}

	public void setInputList(ArrayList<String> inputList) {
		this.inputList = inputList;
	}

	public int getFired() {
		return fired;
	}
	
	

}
