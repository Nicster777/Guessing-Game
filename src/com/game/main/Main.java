package com.game.main;

import java.awt.EventQueue;

public class Main {
	
	private ColorGen colGen = new ColorGen();
	private NumberGen numGen = new NumberGen();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	
	
	
}
