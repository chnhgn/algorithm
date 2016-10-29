package sort;

public class HeapSort {

	public static StringBuffer buffer = new StringBuffer();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {2,4,5,7,9,10,8,3,6,1,2,7,9};
		HeapSort hs = new HeapSort();
		hs.MaxHeapSort(arr, arr.length);
		System.out.println(buffer);
	}
	
	public void MaxHeapSort(int[] arr, int len){
		if (len!=0) {
			// Compare the current element with its parent node
			for (int i = len-1; i > 0; i--) {
				if (arr[i]>arr[(i-1)/2]) {
					int temp = arr[(i-1)/2];
					arr[(i-1)/2] = arr[i];
					arr[i] = temp;
				}
			}
			
			// Save the top biggest element
			buffer.append(String.valueOf(arr[0]));
			buffer.append(" ");
			
			// Forward one step for the whole original array
			for (int m = 0; m < len-1; m++) {
				arr[m] = arr[m+1];
			}
			len--;
			MaxHeapSort(arr, len);
			
		}
	}

}
