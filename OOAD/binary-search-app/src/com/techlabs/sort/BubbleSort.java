package com.techlabs.sort;

public class BubbleSort implements ISortable {

	int[] numbers;

	@Override
	public int[] sortArray(int[] numbers) {
		this.numbers = numbers;
		bubbleSort();
		return numbers;
	}

	private void bubbleSort() {
		int temp;
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				if (numbers[i] < numbers[j]) {
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}

			}
		}
	}

}
