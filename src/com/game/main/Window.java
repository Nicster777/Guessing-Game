package com.game.main;

import java.awt.DisplayMode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Window {

	JFrame frame;
	private JTextField guessField;
	private JTextField capField;
	private NumberGen gen = new NumberGen();
	
	private int score = 0;
	
	public Window() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton guessButton = new JButton("Guess");
		guessButton.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(guessButton);
		
		guessField = new JTextField();
		guessField.setBounds(10, 193, 119, 23);
		frame.getContentPane().add(guessField);
		guessField.setColumns(10);
		
		JLabel lblEnterYourGuess = new JLabel("Enter Your Guess");
		lblEnterYourGuess.setBounds(10, 166, 119, 14);
		frame.getContentPane().add(lblEnterYourGuess);
		
		JLabel lblPickMode = new JLabel("Pick Mode");
		lblPickMode.setBounds(10, 11, 63, 14);
		frame.getContentPane().add(lblPickMode);
		
		JRadioButton rdbtnColors = new JRadioButton("Colors");
		rdbtnColors.setBounds(10, 32, 72, 23);
		frame.getContentPane().add(rdbtnColors);
		
		JRadioButton rdbtnNumbers = new JRadioButton("Numbers");
		rdbtnNumbers.setSelected(true);
		rdbtnNumbers.setBounds(10, 58, 89, 23);
		frame.getContentPane().add(rdbtnNumbers);
		
		capField = new JTextField();
		capField.setBounds(10, 88, 119, 23);
		frame.getContentPane().add(capField);
		capField.setColumns(10);
		
		JButton btnSetCap = new JButton("Set Cap");
		btnSetCap.setBounds(10, 122, 89, 23);
		frame.getContentPane().add(btnSetCap);
		
		JTextArea output = new JTextArea();
		output.setEditable(false);
		output.setLineWrap(true);
		output.setBounds(168, 11, 266, 205);
		frame.getContentPane().add(output);
		
		
		/* ACTION LISTENERS */
		
		// guess button
		guessButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				output.setText("");
				
				
				if (rdbtnNumbers.isSelected()) {
					if (gen.getCap() != 0) {
						int guess;
						
						try {
							guess = Integer.parseInt(guessField.getText());
							int rand = gen.genNumber();
							
							
							if (guess == rand) {
								score++;
							}
							
							output.append("Guess: " + guess + "\n");
							output.append("Number: " + rand + "\n");
							output.append("Score: " + score + "\n");
						} catch (NumberFormatException ex) {
							output.append("Enter a Guess (Number)\n");
							guess = 0;
							guessField.requestFocus();
						}
						
					} else {
						output.append("Set a Cap Number!\n");
						capField.requestFocus();
					}
				} else if (rdbtnColors.isSelected()) {
					
				}
			}
				
		});
		
		// get cap button
		btnSetCap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Set Cap Pressed");
				System.out.println(capField.getText());
				int cap = Integer.parseInt(capField.getText());
				output.append("Number Cap Set To: " + cap + "\n");
				gen.setCap(cap);
			}
		});
		
		// radio button colors
		rdbtnColors.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnNumbers.setSelected(false);
				capField.setEnabled(false);
				btnSetCap.setEnabled(false);
				output.append("Switched to Color mode.\n");
			}
		});
		
		// radio buttons numbers
		rdbtnNumbers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnColors.setSelected(false);
				capField.setEnabled(true);
				btnSetCap.setEnabled(true);
				output.append("Switched to Number mode.\n");
			}
		});
	}
}
