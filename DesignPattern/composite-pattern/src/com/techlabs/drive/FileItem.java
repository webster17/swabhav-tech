package com.techlabs.drive;

public class FileItem implements IDrivableItem {

	private String name, extension;
	private Double size;

	public FileItem(String name, Double size, String extension) {
		this.name = name;
		this.size = size;
		this.extension = extension;
	}

	@Override
	public void showContent(int level) {
		
		int i = level;
		while(i!=0){
			System.out.print("\t");
			i--;
		}
		
		System.out.println("File: {" + name + "." + extension + ", " + size
				+ "}");
		
	}
}