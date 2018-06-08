package com.techlabs.game;

import com.techlabs.custom.exceptions.CellAlreadyMarkedException;

public class Board {

	private Cell[][] board;
	private int row, column;

	public Board(int row, int column) {
		this.row=row;
		this.column = column;
		board = new Cell[this.row][this.column];
		initializeBoard();
	}
	
	public int getRow(){
		return row;
	}
	public int getColumn(){
		return column;
	}

	public void setCell(int row, int column, Mark mark)
			throws ArrayIndexOutOfBoundsException, CellAlreadyMarkedException {
		board[row][column].setMark(mark);
	}

	public Cell getCell(int row, int column) {
		return board[row][column];
	}

	public void initializeBoard() {
		for (int r = 0; r < row; r++)
			for (int c = 0; c < column; c++)
				board[r][c] = new Cell(Mark.NULL);
	}

	public Boolean isAllCellMarked() {
		for (int r = 0; r < row; r++)
			for (int c = 0; c < column; c++)
				if (board[r][c].getMark() == Mark.NULL)
					return false;
		return true;
	}

	public Cell[][] getBoard() {
		return board;
	}
}
