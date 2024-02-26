package com.hackerrank.interviewPreparationKit.Arrays;

import java.util.ArrayList;
import java.util.List;

// link: https://www.hackerrank.com/challenges/crush/problem
public class ArrayManipulation {

	public static void main(String[] args) {
		
		List<List<Integer>> q1 = new ArrayList<>();
		q1.add(new ArrayList<>() {
			{
				add(1); add(5); add(3);
			}
		});
		q1.add(new ArrayList<>() {
			{
				add(4); add(8); add(7);
			}
		});
		q1.add(new ArrayList<>() {
			{
				add(6); add(9); add(1);
			}
		});
		
		List<List<Integer>> q2 = new ArrayList<>();
		q2.add(new ArrayList<>() {
			{
				add(1); add(2); add(100);
			}
		});
		q2.add(new ArrayList<>() {
			{
				add(2); add(5); add(100);
			}
		});
		q2.add(new ArrayList<>() {
			{
				add(3); add(4); add(100);
			}
		});
		// n = 10
		//a b k
		//1 5 3
		//4 8 7
		//6 9 1
		// return 10
		System.out.println("queries: ");
		printArr(q1);
		System.out.println(arrayManipulation(10, q1));
		
		// n = 5
		//a b  k
		//1 2 100
		//2 5 100
		//3 4 100
		// return 200
		System.out.println("queries: ");
		printArr(q2);
		System.out.println(arrayManipulation(5, q2));
	}
	
	public static long arrayManipulation(int n, List<List<Integer>> queries) {
		int[] operationList = new int[n];
		long maxAccumulate = -9999;
		
		for(int i = 0; i < n; i++) {
			operationList[i] = 0;
		}
		
		for(List<Integer> query : queries) {
			operationList[query.get(0) - 1] += query.get(2);
			int index = query.get(1);
			if(index < n) {
				operationList[index] += -query.get(2);
			}
		}
		
		long accumulate = 0;
		for(int i = 0; i < n; i++) {
			accumulate += operationList[i];
			maxAccumulate = Math.max(accumulate, maxAccumulate);
		}
		
		return maxAccumulate;
	}
	
	public static long naiveArrayManipulation(int n, List<List<Integer>> queries) {
		long[] zeroList = new long[n];
		long maxItem = 0;
		
		for(int i = 0; i < n; i++) {
			zeroList[i] = 0;
		}
		
		for(List<Integer> query : queries) {
			int startIdx = query.get(0) - 1;
			int endIdx = query.get(1) - 1;
			int summand = query.get(2);
			
			for(int i = startIdx; i <= endIdx; i++) {
				zeroList[i] = zeroList[i] + summand; 
			}
		}
		
		for(int i = 0; i < n; i++) {
			maxItem = Math.max(maxItem, zeroList[i]);
		}
		
		return maxItem;
	}
	
	public static void printArr(List<List<Integer>> arr) {
		arr.forEach(r -> {
			r.forEach(item -> System.out.print(item + " "));
			System.out.println();
		});
		System.out.println();
	}
	
	public static void printArr(long[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
