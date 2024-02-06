package com.hackerrank.interviewPreparationKit.Arrays;

public class MinimumSwaps2 {

	public static void main(String[] args) {
		// 7, 1, 3, 2, 4, 5, 6
		// return 5
		int[] arr = new int[] {7, 1, 3, 2, 4, 5, 6};
		System.out.println(minimumSwaps(arr));
		
		// 4 3 1 2
		// return 3
		int[] arr2 = new int[] {4, 3, 1, 2};
		System.out.println(minimumSwaps(arr2));
		
		// 2 3 4 1 5
		// return 3
		int[] arr3 = new int[] {2, 3, 4, 1, 5};
		System.out.println(minimumSwaps(arr3));
	}
	
	// Complete the minimumSwaps function below.
    public static int minimumSwaps(int[] arr) {
    	int swapCount = 0;
    	int arrLen = arr.length;
    	
    	for(int i = 0; i < arrLen - 1; i++) {
    		if(i + 1 != arr[i]) {
    			for(int j = i + 1; j < arrLen; j++) {
        			if(arr[j] == i + 1) {
        				int temp = arr[i];
        				arr[i] = arr[j];
        				arr[j] = temp;
        				
        				++swapCount;
        				break;
        			}
        		}
    		}
    	}
    	
    	return swapCount;
    }
    
    public static void printArr(int[] arr) {
    	for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
    	System.out.println();
    }
}
