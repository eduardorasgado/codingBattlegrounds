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
		
		// 1, 2, 3, 5, 4, 6, 7, 8
		// print 1
		minimumBribes(arr1);
		// 4 1 2 3
		// print Too chaotic
		minimumBribes(arr2);
		// 2, 1, 5, 3, 4
		// print 3
		minimumBribes(arr3);
		// 2, 5, 1, 3, 4
		// print Too chaotic
		minimumBribes(arr4);
	}

	/*
	 * No value is returned. Print the minimum number of bribes necessary or Too chaotic 
	 * if someone has bribed more than  people.
	 * 
	 */
	public static void minimumBribes(List<Integer> q) {
		printArr(q);
		
		String result = "";
		System.out.println(result);
	}
	
	public static void printArr(List<Integer> q) {
		for (int i = 0; i < q.size(); i++) {
			System.out.print(q.get(i) + " ");
		}
		System.out.println();
	}
}
