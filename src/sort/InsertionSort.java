package sort;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {2,4,5,7,9,10,8,3,6,1,2,7,9};
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while (j>0 && arr[j]<arr[j-1]) {
				int temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
				j--;
			}
		}
		
		for (int i : arr) {
			System.out.println(i + " ");
		}
	}

}
