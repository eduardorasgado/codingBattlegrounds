package com.hackerrank.interviewPreparationKit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRotation {

	public static void main(String[] args) {
		//5 4
		//1 2 3 4 5
		List<Integer> arr1 = new ArrayList<>() {
			{
				add(1); add(2); add(3); add(4); add(5);
			}
		};
				
		printArr(arr1);
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
	
	/*
	 * invert the array
	 * calculate new items index with modulus and insert inverted array at new pos in list
	 * invert the list   
	 *  
	 */
	public static List<Integer> rotLeft(List<Integer> a, int d) {
		int aLength = a.size(); 
		
		if(d == aLength) {
			return a;
		}
		
		List<Integer> resultList = new ArrayList<>();
	    List<Integer> invertedArr = new ArrayList<>();
	    Integer[] invertedResultArray = new Integer[aLength];
	    
	    for(int i = aLength - 1; i >= 0; i--) {
	    	invertedArr.add(a.get(i));
	    }
	    
		for (int i = 0; i < aLength; i++) {
			invertedResultArray[(i + d) % (aLength)] = invertedArr.get(i);
		}
		
		for(int i = aLength - 1; i >= 0; i--) {
			resultList.add(invertedResultArray[i]);
	    }
		
	    return resultList;
	}
}
