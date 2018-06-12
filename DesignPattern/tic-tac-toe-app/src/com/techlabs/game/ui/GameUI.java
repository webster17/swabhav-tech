package com.techlabs.game.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class GameUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameUI frame = new GameUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(111, 68, 49, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(160, 68, 49, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(209, 68, 49, 38);
		contentPane.add(btnNewButton_2);
		
		JButton button = new JButton("New button");
		button.setBounds(111, 106, 49, 38);
		contentPane.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(160, 106, 49, 38);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(209, 106, 49, 38);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(111, 144, 49, 38);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(160, 144, 49, 38);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(209, 144, 49, 38);
		contentPane.add(button_5);
		
		JButton btnStartButton = new JButton("Start Button");
		btnStartButton.setBounds(136, 23, 89, 23);
		contentPane.add(btnStartButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(163, 214, 46, 14);
		contentPane.add(lblNewLabel);
	}
}
