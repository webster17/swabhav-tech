package com.techlabs.game;

import com.techlabs.analyzer.GameStatus;
import com.techlabs.analyzer.ResultAnalyzer;
import com.techlabs.custom.exceptions.CellAlreadyMarkedException;
import com.techlabs.player.Player;

public class Game {

	private Board board;
	private Player[] player;
	private ResultAnalyzer resultAnalyzer;

	public Game() {

	}

	public Game(Board board, Player[] player, ResultAnalyzer resultAnalyzer) {
		super();
		this.board = board;
		this.player = player;
		this.resultAnalyzer = resultAnalyzer;
	}
	int currentPlayer=1;
	public int currentPlayer()
	{
		currentPlayer++;
		return currentPlayer%2;
	}

	public String play(int row, int column, Mark mark)
			throws ArrayIndexOutOfBoundsException, CellAlreadyMarkedException {
		board.setCell(row, column, mark);
		int currentPlayer=currentPlayer();
		GameStatus gameStatus = resultAnalyzer.checkResult(mark);
		if (gameStatus == GameStatus.WIN) {
			return("Player " + player[currentPlayer].getName() + " has won");
		}
		else if (gameStatus == GameStatus.DRAW)
			return("Game is draw");
		else
			return(resultAnalyzer.checkResult(mark)).toString();
	}

	
}
