package com.techlabs.sort;

public class MergeSort implements ISortable {

	private int numbers[];

	@Override
	public int[] sortArray(int[] numbers) {
		this.numbers = numbers;
		mergeSort(0, numbers.length - 1);
		return numbers;
	}

	private void merge(int left, int middle, int right) {
		int i, j, k;
		int n1 = middle - left + 1;
		int n2 = right - middle;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (i = 0; i < n1; i++)
			L[i] = numbers[left + i];
		for (j = 0; j < n2; j++)
			R[j] = numbers[middle + 1 + j];

		i = 0;
		j = 0;
		k = left;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				numbers[k] = L[i];
				i++;
			} else {
				numbers[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			numbers[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			numbers[k] = R[j];
			j++;
			k++;
		}
	}

	private void mergeSort(int left, int right) {
		if (left < right) {
			int middle = left + (right - left) / 2;

			mergeSort(left, middle);
			mergeSort(middle + 1, right);

			merge(left, middle, right);
		}
	}
}