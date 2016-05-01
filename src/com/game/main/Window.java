package com.game.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;
import javax.swing.JPopupMenu;

public class Window {

	JFrame frame;
	private JTextField guessField;
	private JTextField capField;
	
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
		output.setWrapStyleWord(true);
		output.setEditable(false);
		output.setBounds(168, 11, 266, 205);
		frame.getContentPane().add(output);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(345, 227, 89, 23);
		frame.getContentPane().add(btnClear);
		
		
		/* ACTION LISTENERS */
		
		// guess button
		guessButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Guess Pressed");
			}
		});
		
		// get cap button
		btnSetCap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Set Cap Pressed");
				System.out.println(capField.getText());
				output.append("Number Cap Set To: " + capField.getText() + "\n");
			}
		});
		
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clear Pressed");
				output.setText("");
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
