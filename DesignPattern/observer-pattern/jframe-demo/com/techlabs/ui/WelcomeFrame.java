package com.techlabs.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.techlabs.listener.GoodByeListener;
import com.techlabs.listener.HelloListener;

public class WelcomeFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton jButton;
	private JLabel jLabel;

	public WelcomeFrame() {
		super("My First JFrame using Swing");
		makeGUI();
	}

	private void makeGUI() {
		this.setSize(400, 400);
		this.setLayout(new GridLayout(4, 1));

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		jLabel = new JLabel("Hover on a button to see changes", JLabel.CENTER);
		jLabel.setSize(50, 100);

		jButton = new JButton("Hover on me!");
		jButton.setSize(50, 20);
		jButton.setBackground(Color.RED);

		this.add(jLabel);
		this.add(jButton);
		jButton.addActionListener(new GoodByeListener());
		jButton.addActionListener(new HelloListener());

		this.setVisible(true);
	}
}
