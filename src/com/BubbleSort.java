package com;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {2,4,5,7,9,10,8,3,6,1,2,7,9};
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {		// Swap
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
