package com.hackerrank.interviewPreparationKit.Arrays;

import java.util.ArrayList;
import java.util.List;

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
		arrayManipulation(10, q1);
		
		// n = 5
		//a b  k
		//1 2 100
		//2 5 100
		//3 4 100
		// return 200
		System.out.println("queries: ");
		printArr(q2);
		arrayManipulation(5, q2);
	}

	public static long arrayManipulation(int n, List<List<Integer>> queries) {
		return 0L;
	}
	
	public static void printArr(List<List<Integer>> queries) {
		queries.forEach(q -> {
			q.forEach(item -> System.out.print(item + " "));
			System.out.println();
		});
		System.out.println();
	}

}
