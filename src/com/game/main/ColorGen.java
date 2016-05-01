package com.game.main;

import java.util.Random;

public class ColorGen {
	
	private Random rand = new Random();
	private String[] colors = {"Blue","Red","Green","Yellow"};
	
	public String genColor() {
		return colors[rand.nextInt(colors.length)];
	}
}
