package sort;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {2,4,5,2,9,4,8,3,9,2,0,1,12,30,25,26,27,10};
		int len = arr.length;
		int h = 1;
		while (h < len) { //1, 4, 13, 40...
			h = 3*h + 1;
		}
		
		while (h >= 1) {
			for (int i = h; i < len; i++) {		// The step should be the descending order to eliminate and 
												// step length cannot exceed the array length
				for (int j = i; j>=h && arr[j]<arr[j-h]; j-=h) {
					// Swap the position if the previous is less then the latter one
					int temp = arr[j];
					arr[j] = arr[j-h];
					arr[j-h] = temp;
				}
			}
			
			// Go to the next step length
			h = h/3;
			
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
