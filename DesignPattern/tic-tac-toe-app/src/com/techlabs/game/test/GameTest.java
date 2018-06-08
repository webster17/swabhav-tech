package com.techlabs.game.test;

import com.techlabs.analyzer.ResultAnalyzer;
import com.techlabs.custom.exceptions.CellAlreadyMarkedException;
import com.techlabs.game.Board;
import com.techlabs.game.Game;
import com.techlabs.game.Mark;
import com.techlabs.player.Player;

public class GameTest {

	public static void main(String args[])
			throws ArrayIndexOutOfBoundsException, CellAlreadyMarkedException {
		Board board = new Board(3,3);
		Player p1 = new Player("Sarvesh", Mark.O);
		Player p2 = new Player("Atharv", Mark.X);
		Player[] players = { p1, p2 };

		ResultAnalyzer resultAnalyzer = new ResultAnalyzer(board);
		Game game = new Game(board, players, resultAnalyzer);

		System.out.println(game.play(0, 0, p1.getMark()));
		displayBoard(board);
		System.out.println(game.play(0, 1, p2.getMark()));
		displayBoard(board);
		System.out.println(game.play(1, 2, p1.getMark()));
		displayBoard(board);
		System.out.println(game.play(0, 2, p2.getMark()));
		displayBoard(board);
		System.out.println(game.play(1, 0, p1.getMark()));
		displayBoard(board);
		System.out.println(game.play(1, 1, p2.getMark()));
		displayBoard(board);
		System.out.println(game.play(2, 0, p1.getMark()));
		displayBoard(board);

	}

	public static void displayBoard(Board board) {
		int cellCount =1;
		for (int row = 0; row < board.getRow(); ++row) {
			for (int col = 0; col < board.getColumn(); ++col) {
				if (board.getCell(row, col).getMark() == Mark.NULL)
					System.out.print(cellCount);
				else
					System.out.print(board.getCell(row, col).getMark() + " ");
				if (col != board.getColumn() - 1) {
					System.out.print("\t|\t"); // print vertical partition
				}
				cellCount++;
			}
			System.out.println();
			if (row != board.getRow() - 1) {		
				System.out.println("-----------------------"); // print horizontal partition
			}
		}
		System.out.println();
	}
}