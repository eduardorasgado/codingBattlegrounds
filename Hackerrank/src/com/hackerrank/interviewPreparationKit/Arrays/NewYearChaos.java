package com.hackerrank.interviewPreparationKit.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
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
		System.out.println();
		// 4 1 2 3
		// print Too chaotic
		//printArr(arr2);
		minimumBribes(arr2);
		System.out.println();
		// 2, 1, 5, 3, 4
		// print 3
		//printArr(arr3);
		minimumBribes(arr3);
		System.out.println();
		// 2, 5, 1, 3, 4
		// print Too chaotic
		//printArr(arr4);
		minimumBribes(arr4);
		System.out.println();
		// print 4
		// 1 2 5 3 4 7 8 6
		minimumBribes(arr5);
		System.out.println();
		// Print 7
		// 1 2 5 3 7 8 6 4
		minimumBribes(arr6);
		System.out.println();
		
	}

	/*
	 * No value is returned. Print the minimum number of bribes necessary or Too chaotic 
	 * if someone has bribed more than  people.
	 * 
	 */	
	public static void minimumBribes(List<Integer> q) {
		String result = "Too chaotic";
 		int qLen = q.size();
 		int minBribes = 0;
 		boolean isTooChaotic = false;
 		
 		HashMap<Integer, Integer> bribeMap = new HashMap<>();
		q.stream().forEach(i -> bribeMap.put(i, 0));

		boolean swapped;
		for(int i = 0; i < qLen; i++) {
			swapped = false;
			
			for(int j = 0; j < qLen - i - 1; j++) {
				if(q.get(j) > q.get(j + 1)) {
					bribeMap.replace(q.get(j), bribeMap.get(q.get(j)) + 1);
					
					swap(q, j, j + 1);
					swapped = true;
				}								  
			}
			
			if(!swapped) {
				break;
			}
		}
		
		for(var entry : bribeMap.entrySet()) {
			if(entry.getValue() < 3) {
				minBribes += entry.getValue();
			} else {
				isTooChaotic = true;
				break;
			}
		}
		
		if(!isTooChaotic) {
			result = String.valueOf(minBribes);
		}
		
		System.out.println(result);
	}

	// i j
	// 5	       7
	// (5 + 7) 12  7
	// 12          (12 - 7) 5
	// (12 - 5) 7  5
	public static void swap(List<Integer> q, int i, int j) {
		
		q.set(i, q.get(i) + q.get(j));
		q.set(j, q.get(i) - q.get(j));
		q.set(i, q.get(i) - q.get(j));
	}
	
	public static void printArr(List<Integer> q) {
		for (int i = 0; i < q.size(); i++) {
			System.out.print(q.get(i) + " ");
		}
		System.out.println();
	}
}
