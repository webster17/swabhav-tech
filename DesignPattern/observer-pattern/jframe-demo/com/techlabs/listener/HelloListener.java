package com.techlabs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Hey! Hello...");		
	}

}
