package com;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {2,4,5,7,9,10,8,3,6,1,2,7,9};
		QuickSort qs = new QuickSort();
		qs.sort(arr, 0, arr.length-1);
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public void sort(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		if (left < right) {
			int key = arr[left];	// This is the key value
			int low = left;
			int high = right;
			while (low < high) {	// Sort for one round
				while (low< high && arr[high]>key) {
					high--;
				}
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				
				while (low<high && arr[low]<=key) {
					low++;
				}
				temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				
			}
			
			sort(arr, left, low-1);		// left part to sort
			sort(arr, high+1, right);	// right part to sort
			
		}
		
	}
	
}
