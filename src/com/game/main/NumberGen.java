package com.game.main;

import java.util.Random;

public class NumberGen {
	
	private Random rand = new Random();
	private int cap;
	
	public NumberGen() {
		cap = 0;
	}
	
	public void setCap(int c) {
		cap = c;
	}
	
	public int getCap() {
		return cap;
	}
	
	public int genNumber() {
		return rand.nextInt(cap + 1);
	}
}
