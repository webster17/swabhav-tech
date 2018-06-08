package com.techlabs.drive;

import java.util.ArrayList;
import java.util.List;

public class FolderItem implements IDrivableItem {

	private String name;
	private List<IDrivableItem> iDrivableItems;

	public FolderItem(String name) {
		this.name = name;
		iDrivableItems = new ArrayList<IDrivableItem>();
	}

	@Override
	public void showContent(int level) {

		int i = level;
		while(i!=0){
			System.out.print("\t");
			i--;
		}
		
		System.out.println("Folder: {" + name + "}");
		for(IDrivableItem iDrivableItem: iDrivableItems)
			iDrivableItem.showContent(level+1);
	}

	public void add(IDrivableItem iDrivableItem) {
		iDrivableItems.add(iDrivableItem);
	}

	public void remove(IDrivableItem iDrivableItem) {
		iDrivableItems.remove(iDrivableItem);
	}
}