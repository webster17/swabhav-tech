package com.techlabs.analyzer;

import com.techlabs.game.Board;
import com.techlabs.game.Mark;

public class ResultAnalyzer {

	Board board;

	public ResultAnalyzer(Board board) {
		this.board = board;
	}

	private int checkRowResult(Mark mark, int win) {
		for (int r = 0; r < board.getRow(); r++) {
			for (int c = 0; c < board.getColumn(); c++) {
				if (board.getCell(r, c).getMark() == mark) {
					win = 1;
				} else {
					win = 0;
					break;
				}
			}
			if (win == 1)
				break;
		}
		return win;
	}

	private int checkColumnResult(Mark mark, int win) {
		for (int c = 0; c < board.getColumn(); c++) {
			for (int r = 0; r < board.getRow(); r++) {
				if (board.getCell(r, c).getMark() == mark) {
					win = 1;
				} else {
					win = 0;
					break;
				}
			}
			if (win == 1)
				break;
		}
		return win;
	}

	private int checkDiagonalResult(Mark mark, int win) {
		for (int i = 0; i < board.getRow(); i++) {
			if (board.getCell(i, i).getMark() == mark) {
				win = 1;
			} else {
				win = 0;
				break;
			}
		}

		if (win == 0) {
			for (int r = 0; r < board.getRow(); r++) {
				int generatedColumn = board.getRow() - r - 1;
				if (board.getCell(r, generatedColumn).getMark() == mark) {
					win = 1;
				} else {
					win = 0;
					break;
				}
			}
		}
		return win;
	}

	public GameStatus checkResult(Mark mark) {
		if (checkRowResult(mark, 0) == 1 || checkColumnResult(mark, 0) == 1
				|| checkDiagonalResult(mark, 0) == 1)
			return GameStatus.WIN;
		else if (board.isAllCellMarked())
			return GameStatus.DRAW;
		else
			return GameStatus.PROGRESS;
	}
}
