package com.collections.sort;

import java.util.Comparator;
import com.techlabs.collections.LineItem;

public class SortByNameComparator implements Comparator<LineItem>{

	@Override
	public int compare(LineItem lineItem1, LineItem lineItem2) {
		return lineItem1.getName().compareTo(lineItem2.getName());
	}

}
