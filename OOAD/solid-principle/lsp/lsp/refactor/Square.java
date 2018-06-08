package lsp.refactor;

public class Square implements Polygon {
	private int side;

	public Square(int side) {
		this.side = side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	@Override
	public int calculateArea() {
		return side * side;
	}
}