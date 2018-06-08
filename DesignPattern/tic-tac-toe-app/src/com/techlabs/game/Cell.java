package com.techlabs.game;

import com.techlabs.custom.exceptions.CellAlreadyMarkedException;

public class Cell {

	private Mark mark;

	public Cell()
	{
		
	}
	
	public Cell(Mark mark) {
		super();
		this.mark = mark;
	}
	

	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) throws CellAlreadyMarkedException {
		if(this.mark==Mark.NULL)	
			this.mark = mark;
		else throw new CellAlreadyMarkedException("Cell already marked");
	}
}
