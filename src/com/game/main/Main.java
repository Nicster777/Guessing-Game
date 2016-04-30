package com.game.main;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		// maybe add guessing material other than numbers?
		
		// cap will be user assigned later
		int cap = 5; 
		int guess;
		int score = 0;
		String yes = "y";
		
		
		// add a better check later
		
		System.out.println("--Guessing Game (0 - "+cap+")--" + "\n-Enter an letter to stop-\n");
		
		while (yes.toUpperCase().equals("Y")) {
			int num = rand.nextInt(cap + 1);
			
			
			System.out.print("Enter your guess: ");
			
			try {
				guess = sc.nextInt();
			} catch (Exception e) {
				break;
			}
			
			if (guess > cap) {
				System.out.println("Only Numbers (0 - " + cap + "). Try Again.\n");
				continue;
			}
			
			if (guess == num) {
				System.out.println("Correct\n");
				score++;
			} else {
				System.out.println("Incorrect, number was: " + num + "\n");
			}
			
		}
		
		sc.close();
		System.out.println("\nYour final score was: " + score);
	}
}
