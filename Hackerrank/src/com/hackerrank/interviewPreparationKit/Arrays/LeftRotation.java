package com.hackerrank.interviewPreparationKit.Arrays;

import java.util.ArrayList;
import java.util.List;

// link: https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
public class LeftRotation {

	public static void main(String[] args) {
		//5 4
		//1 2 3 4 5
		List<Integer> arr1 = new ArrayList<>() {
			private static final long serialVersionUID = 1L;

			{
				add(1); add(2); add(3); add(4); add(5);
			}
		};
				
		printArr(arr1);
		System.out.println();
		printArr(rotLeft(arr1, 1));
		printArr(rotLeft(arr1, 2));
		printArr(rotLeft(arr1, 3));
		printArr(rotLeft(arr1, 4));
		printArr(rotLeft(arr1, 5));
		printArr(rotLeft(arr1, 6));
		
	}
	
	public static void printArr(List<Integer> arr) {
		for(Integer value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
	
	public static List<Integer> rotLeft(List<Integer> a, int d) {
		int listLen = a.size();
		Integer[] rotatedArr = new Integer[listLen];
		ArrayList<Integer> rotatedList = new ArrayList<>();
		ArrayList<Integer> reversedList = new ArrayList<>();
		
		for(int i = listLen - 1; i >= 0; i--) {
			reversedList.add(a.get(i));
		}
		
		for(int i = 0; i < listLen; i++) {
			int newIdx = Math.floorMod(d + i, listLen);  
			rotatedArr[newIdx] = reversedList.get(i);
		}
		
		for(int i = listLen - 1; i >= 0; i--) {
			rotatedList.add(rotatedArr[i]);
		}
		
		return rotatedList;
	}
}
