package com.techlabs.search.unittest;

import org.junit.Test;
import com.techlabs.sort.MergeSort;

public class UnitTesting {

	@Test
	public void checkIfMergeSortIsWorking() {
		int x[] = new int[] { 1, 2, 3, 5, 4 };
		int y[] = new int[10];
		MergeSort mergeSort = new MergeSort();
		y = mergeSort.sortArray(x);
		for (int element : y)
			System.out.println(element + " ");
	}
}