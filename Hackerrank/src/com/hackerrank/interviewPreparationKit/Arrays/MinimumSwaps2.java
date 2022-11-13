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
    	int minMovements = 0;
    	
    	// selection sort
    	for (int i = 0; i < arr.length - 1; i++) {
    		// if current number is not sorted yet, if so, then go next pos
    		// to avoid searching a greater number where there is no one
    		if(arr[i] != i + 1) {
    			int minIndex = i;
        		
        		for(int j = i + 1; j < arr.length; j++) {
        			
        			if(arr[j] < arr[minIndex]) {
        				minIndex = j;
        			}	
        		}
        		
        		if(minIndex != i) {
        			int temp = arr[minIndex];
            		arr[minIndex] = arr[i];
            		arr[i] = temp;
            		
            		++minMovements;
        		}
    		}
		}
    	
    	return minMovements;
    }
    
    public static void printArr(int[] arr) {
    	for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
    	System.out.println();
    }
}
