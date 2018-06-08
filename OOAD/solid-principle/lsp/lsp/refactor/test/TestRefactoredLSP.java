package lsp.refactor.test;

import lsp.violation.Rectangle;

public class TestRefactoredLSP {
	public static void main(String args[]) {
		Rectangle rectangle = new Rectangle(100, 50);
		shouldnotChangeWidthIfHeightChange(rectangle);
	}
	
	private static void shouldnotChangeWidthIfHeightChange(Rectangle rectangle) {
		int beforeWidth = rectangle.getWidth();
		rectangle.setHeight(20);
		int afterWidth = rectangle.getWidth();
		System.out.println("Value of Width:\nBefore Change\t: " + beforeWidth
				+ "\nAfter Change\t: " + afterWidth);
	}
}