package com.hackerrank.interviewPreparationKit.Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NewYearChaos {

	public static void main(String[] args) {
		// 1, 2, 3, 5, 4, 6, 7, 8
		// print 1
		List<Integer> arr1 = new ArrayList<>() {
			{
				add(1); add(2); add(3); add(5); add(4); add(6); add(7); add(8);
			}
		};
		// 4 1 2 3
		// print Too chaotic
		List<Integer> arr2 = new ArrayList<>() {
			{
				add(4); add(1); add(2); add(3);
			}
		};
		
		// 2, 1, 5, 3, 4
		// print 3
		List<Integer> arr3 = new ArrayList<>() {
			{
				add(2); add(1); add(5); add(3); add(4);
			}
		};
		
		// 2, 5, 1, 3, 4
		// print Too chaotic
		List<Integer> arr4 = new ArrayList<>() {
			{
				add(2); add(5); add(1); add(3); add(4);
			}
		};
		
		// print 4
		// 1 2 5 3 4 7 8 6
		List<Integer> arr5 = new ArrayList<>() {
			{
				add(1); add(2); add(5); add(3); add(4); add(7); add(8); add(6);
			}
		};
		
		// Too chaotic
		// 1 2 5 3 7 8 6 4
		List<Integer> arr6 = new ArrayList<>() {
			{
				add(1); add(2); add(5); add(3); add(7); add(8); add(6); add(4);
			}
		};
		
		// 1, 2, 3, 5, 4, 6, 7, 8
		// print 1
		//printArr(arr1);
		minimumBribes(arr1);
		// 4 1 2 3
		// print Too chaotic
		//printArr(arr2);
		minimumBribes(arr2);
		// 2, 1, 5, 3, 4
		// print 3
		//printArr(arr3);
		minimumBribes(arr3);
		// 2, 5, 1, 3, 4
		// print Too chaotic
		//printArr(arr4);
		minimumBribes(arr4);
		// print 4
		// 1 2 5 3 4 7 8 6
		minimumBribes(arr5);
		// Print 7
		// 1 2 5 3 7 8 6 4
		minimumBribes(arr6);
	}

	/*
	 * No value is returned. Print the minimum number of bribes necessary or Too chaotic 
	 * if someone has bribed more than  people.
	 * 
	 */	
	public static void minimumBribes(List<Integer> q) {
		int resultInt = 0;
		String result = new String("");
		int qLength = q.size();
		int[] brides = new int[qLength];
		
		for (int i = 0; i < brides.length; i++) {
			brides[i] = 0;
		}
		
		int temp = 0;
		boolean swapped = false;
		
		// optimized bubble sort
		for (int i = 0; i < qLength - 1; i++) {
			
			swapped = false;
			for(int j = 0; j < qLength - i - 1; j++) {
				
				if(q.get(j) > q.get(j + 1)) {
					temp = q.get(j);
					
					brides[temp - 1] += 1;
					
					// swapping
					q.set(j, q.get(j + 1));
					q.set(j + 1, temp);
					
					swapped = true;
				}
			}
			
			if(!swapped) {
				break;
			}
		}
		
		for (int i = 0; i < brides.length; i++) {
			
			if(brides[i] < 3) {
				resultInt += brides[i];
				result = String.valueOf(resultInt);
			} else {
				result = "Too chaotic";
				
				break;
			}
			
		}

		System.out.println(result);
		
	}
	
	public static void printArr(List<Integer> q) {
		for (int i = 0; i < q.size(); i++) {
			System.out.print(q.get(i) + " ");
		}
		System.out.println();
	}
}
