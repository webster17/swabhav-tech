package lsp.violation.test;

import lsp.violation.Rectangle;
import lsp.violation.Square;

public class TestLSP {
	public static void main(String args[]) {
		Rectangle rectangle = new Rectangle(100, 50);
		shouldnotChangeWidthIfHeightChange(rectangle);
		Square square = new Square(100);
		shouldnotChangeWidthIfHeightChange(square);
	}

	private static void shouldnotChangeWidthIfHeightChange(Rectangle rectangle) {
		int beforeWidth = rectangle.getWidth();
		rectangle.setHeight(20);
		int afterWidth = rectangle.getWidth();
		System.out.println("Value of Width:\nBefore Change\t: " + beforeWidth
				+ "\nAfter Change\t: " + afterWidth);

	}
}
