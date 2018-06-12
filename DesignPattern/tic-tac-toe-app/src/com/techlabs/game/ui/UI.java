package com.techlabs.game.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import com.techlabs.analyzer.GameStatus;
import com.techlabs.analyzer.ResultAnalyzer;
import com.techlabs.custom.exceptions.CellAlreadyMarkedException;
import com.techlabs.game.Board;
import com.techlabs.game.Game;
import com.techlabs.game.Mark;
import com.techlabs.player.Player;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI implements ActionListener {
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 472, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		button1 = new JButton("1");
		button1.setBounds(34, 29, 97, 79);
		frame.getContentPane().add(button1);
		button1.addActionListener(this);

		button2 = new JButton("2");
		button2.setBounds(180, 29, 97, 79);
		frame.getContentPane().add(button2);
		button2.addActionListener(this);

		button3= new JButton("3");
		button3.setBounds(324, 29, 97, 79);
		frame.getContentPane().add(button3);
		button3.addActionListener(this);

		button4 = new JButton("4");
		button4.setBounds(34, 140, 97, 79);
		frame.getContentPane().add(button4);
		button4.addActionListener(this);

		button5 = new JButton("5");
		button5.setBounds(180, 140, 97, 79);
		frame.getContentPane().add(button5);
		button5.addActionListener(this);

		button6 = new JButton("6");
		button6.setBounds(324, 140, 97, 79);
		frame.getContentPane().add(button6);
		button6.addActionListener(this);

		button7 = new JButton("7");
		button7.setBounds(34, 251, 97, 79);
		frame.getContentPane().add(button7);
		button7.addActionListener(this);

		button8 = new JButton("8");
		button8.setBounds(180, 251, 97, 79);
		frame.getContentPane().add(button8);
		button8.addActionListener(this);

		button9 = new JButton("9");
		button9.setBounds(324, 251, 97, 79);
		frame.getContentPane().add(button9);
		button9.addActionListener(this);
	}

	int currentPlayer = 1;

	public int currentPlayer() {
		currentPlayer++;
		return (currentPlayer % 2);
	}

	Player p1 = new Player("Sarvesh", Mark.O);
	Player p2 = new Player("Atharv", Mark.X);
	Player[] players = { p1, p2 };

	Board board = new Board(3, 3);
	ResultAnalyzer resultAnalyzer = new ResultAnalyzer(board);
	Game game = new Game(board, players, resultAnalyzer);

	@Override
	public void actionPerformed(ActionEvent e) {
		int currentPlayer=currentPlayer();
		int position = 0;
		if (e.getSource() == button1) {
			button1.setText(players[currentPlayer].getMark().toString());
			position = 1;
			button1.setEnabled(false);
		} else if (e.getSource() == button2) {
			button2.setText(players[currentPlayer].getMark().toString());
			position = 2;
			button2.setEnabled(false);
		} else if (e.getSource() == button3) {
			button3.setText(players[currentPlayer].getMark().toString());
			position = 3;
			System.out.println("inside button 3"+position);
			button3.setEnabled(false);
		} else if (e.getSource() == button4) {
			button4.setText(players[currentPlayer].getMark().toString());
			position = 4;
			button4.setEnabled(false);
		} else if (e.getSource() == button5) {
			button5.setText(players[currentPlayer].getMark().toString());
			position = 5;
			button5.setEnabled(false);
		} else if (e.getSource() == button6) {
			button6.setText(players[currentPlayer].getMark().toString());
			position = 6;
			button6.setEnabled(false);
		} else if (e.getSource() == button7) {
			button7.setText(players[currentPlayer].getMark().toString());
			position = 7;
			button7.setEnabled(false);
		} else if (e.getSource() == button8) {
			button8.setText(players[currentPlayer].getMark().toString());
			position = 8;
			button8.setEnabled(false);
		} else if (e.getSource() == button9) {
			button9.setText(players[currentPlayer].getMark().toString());
			position = 9;
			button9.setEnabled(false);
		}
		try {
			String status = game.play((position - 1) / 3,
					(position - 1) % 3, players[currentPlayer].getMark());
			System.out.println(status);
		} catch (ArrayIndexOutOfBoundsException | CellAlreadyMarkedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
