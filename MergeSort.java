package algorithm;

public class MergeSort {

	public void merge(int arr[], int low, int high) {
		// TODO Auto-generated method stub
		int mid = (high-low)/2+low;
		int prior = low;		// First half
		int posterior = mid + 1;	// Second half
		int buffer[] = new int[high-low+1];		// This is the buffer array to save the compare result
		int k = 0;		// Buffer index
		
		System.out.println("mid="+mid);
		
		while (prior <= mid && posterior <= high) {
			if (arr[prior] <= arr[posterior]) {
				// Save the smaller one to buffer
				buffer[k] = arr[prior];
				prior++;
				k++;
			} else {
				buffer[k] = arr[posterior];
				posterior++;
				k++;
			}
		}
		
		if (prior <= mid) {		// The first half has rest elements
			for (int i = prior; i <= mid; i++) {
				buffer[k] = arr[i];
				k++;
			}
		}
		
		if (posterior <= high) {		// The second half has rest elements
			for (int i = posterior; i <= high; i++) {
				buffer[k] = arr[i];
				k++;
			}
		}
		
		// Copy buffer to the original array
		int m = low;
		for (int i = 0; i < buffer.length; i++) {
			arr[m] = buffer[i];
			m++;
		}
		
	}
	
	
	public void split(int gap, int arr[]){		// Split the whole array with different span and apply the merge-sort to each span
		int span = gap*2;
		for (int i = 0; i < arr.length; i+=span) {
			int start = i;
			int end = i+span-1;
			if (end > arr.length-1) {
				end = arr.length-1;
			}
			System.out.println("start:"+start+"   end:"+end);
			
			merge(arr, start, end);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort ms = new MergeSort();
		int arr[] = {9,1,5,3,4,2,6,8,7};
		for (int i = 1; i < arr.length; i*=2) {
			System.out.println("gap="+i);
			ms.split(i, arr);
		}
		
		
		// Print all the sorted elements
		for (int i : arr) {
			System.out.println(i);
		}
		
	}

}
















