package sort;

import java.util.Arrays;

public class MergeSort {

	public static int[] sort(int[] nums, int low, int high) {  
        int mid = (low + high) / 2; 
        // Split the left/right part to smaller part then merge the atom part recursively
        if (low < high) {  
            // Left part 
            sort(nums, low, mid);  
            // Right part 
            sort(nums, mid + 1, high);  
            // Merge the left part and right part  
            merge(nums, low, mid, high);  
        }  
        return nums;  
    }
	
	
	public static void merge(int[] nums, int low, int mid, int high) {
		int[] temp = new int[high - low +1]; // Use a temporary array to store the span
		int i = low;
		int j = mid +1;
		int k = 0;
		
		while (i <= mid && j <= high) {		// The comparison part is the sort of the Quick-Sort, same as it
			if (nums[i] < nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}
		
		while (i <= mid) {					// Append the rest elements of the left part to the temporary array
			temp[k++] = nums[i++];
		}
		
		while (j <= high) {					// Append the rest elements of the right part to the temporary array
			temp[k++] = nums[j++];
		}
		
		// Replace the sorted span to the corresponding position in the original array
		for (int k2 = 0; k2 < temp.length; k2++) {
			nums[low+k2] = temp[k2];
		}
		
	}


	public static void main(String[] args) {
		int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4, 12, 16, 10, 11, 14, 13, 15 ,2};  
		  
        MergeSort.sort(nums, 0, nums.length-1);  
        System.out.println(Arrays.toString(nums));
	}

}
















