package com.techlabs.search.test;

import com.techlabs.search.BinarySearch;
import com.techlabs.sort.BubbleSort;
import com.techlabs.sort.MergeSort;

public class TestSearch {

	public static void main(String args[]) {
		int numbers[] = new int[] { 45, 33, 54, 25, 150 };
		BinarySearch binarySearch1 = new BinarySearch(numbers, new MergeSort(),54);
		int position = binarySearch1.binarySearch(0, numbers.length - 1);
		System.out.println("Given key is at " + (position + 1) + " position");
		
		BinarySearch binarySearch2 = new BinarySearch(numbers, new BubbleSort(),33);
		position = binarySearch2.binarySearch(0, numbers.length-1);
		System.out.println("Given key is at " + (position + 1) + " position");
	}
}
