package com.techlabs.search;

import com.techlabs.sort.ISortable;

public class BinarySearch {

	private int[] numbers;
	ISortable sort;
	int searchKey;

	public BinarySearch(int[] numbers, ISortable sort, int searchKey) {
		this.numbers = numbers;
		this.sort = sort;
		this.searchKey = searchKey;
	}

	private void sortNumbers() {
		numbers = sort.sortArray(numbers);
	}

	public int binarySearch(int startIndex, int lastIndex) {
		sortNumbers();
		if (lastIndex >= startIndex) {
			int mid = startIndex + (lastIndex - startIndex) / 2;

			if (numbers[mid] == searchKey)
				return mid;

			if (numbers[mid] > searchKey)
				return binarySearch(startIndex, mid - 1);

			return binarySearch(mid + 1, lastIndex);
		}
		return -1;
	}
}
