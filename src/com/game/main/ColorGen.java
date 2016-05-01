package com.game.main;

import java.util.Random;

public class ColorGen {
	
	private String[] colors = {"Blue", "Black", "Red"};
	
	private Random rand = new Random();
	private int index;
	
	public String genColor() {
		
		index = rand.nextInt(colors.length);
		
		return colors[index];
		
	}
	
	
}
