package com.hackerrank.interviewPreparationKit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class TwoDArrayDs {

	public static void main(String[] args) {
		List<List<Integer>> arr = new ArrayList<>();
		
		arr.add(new ArrayList<>() {
			{
				add(-9); add(-9); add(-9); add(1); add(1); add(1);
			}
		});
		arr.add(new ArrayList<>() {
			{
				add(0); add(-9); add(0); add(4); add(3); add(2);
			}
		});
		arr.add(new ArrayList<>() {
			{
				add(-9); add(-9); add(-9); add(1); add(2); add(3);
			}
		});
		arr.add(new ArrayList<>() {
			{
				add(0); add(0); add(8); add(6); add(6); add(0);
			}
		});
		arr.add(new ArrayList<>() {
			{
				add(0); add(0); add(0); add(-2); add(0); add(0);
			}
		});
		arr.add(new ArrayList<>() {
			{
				add(0); add(0); add(1); add(2); add(4); add(0);
			}
		});
		
		System.out.println(hourglassSum(arr));
		
		//-1 -1 0 -9 -2 -2
		//-2 -1 -6 -8 -2 -5
		//-1 -1 -1 -2 -3 -4
		//-1 -9 -2 -4 -4 -5
		//-7 -3 -3 -2 -9 -9
		//-1 -3 -1 -2 -4 -5
		
		List<List<Integer>> arr2 = new ArrayList<>();
		
		arr2.add(new ArrayList<>() {
			{
				add(-1); add(-1); add(0); add(-9); add(-2); add(-2);
			}
		});
		arr2.add(new ArrayList<>() {
			{
				add(-2); add(-1); add(-6); add(-8); add(-2); add(-5);
			}
		});
		arr2.add(new ArrayList<>() {
			{
				add(-1); add(-1); add(-1); add(-2); add(-3); add(-4);
			}
		});
		arr2.add(new ArrayList<>() {
			{
				add(-1); add(-9); add(-2); add(-4); add(-4); add(-5);
			}
		});
		arr2.add(new ArrayList<>() {
			{
				add(-7); add(-3); add(-3); add(-2); add(-9); add(-9);
			}
		});
		arr2.add(new ArrayList<>() {
			{
				add(-1); add(-3); add(-1); add(-2); add(-4); add(-5);
			}
		});
		 
		System.out.println();
		System.out.println(hourglassSum(arr2));
		
		//0 -4 -6 0 -7 -6
		//-1 -2 -6 -8 -3 -1
		//-8 -4 -2 -8 -8 -6
		//-3 -1 -2 -5 -7 -4
		//-3 -5 -3 -6 -6 -6
		//-3 -6 0 -8 -6 -7
		
		List<List<Integer>> arr3 = new ArrayList<>();
		
		arr3.add(new ArrayList<>() {
			{
				add(0); add(-4); add(-6); add(0); add(-7); add(-6);
			}
		});
		arr3.add(new ArrayList<>() {
			{
				add(-1); add(-2); add(-6); add(-8); add(-3); add(-1);
			}
		});
		arr3.add(new ArrayList<>() {
			{
				add(-8); add(-4); add(-2); add(-8); add(-8); add(-6);
			}
		});
		arr3.add(new ArrayList<>() {
			{
				add(-3); add(-1); add(-2); add(-5); add(-7); add(-4);
			}
		});
		arr3.add(new ArrayList<>() {
			{
				add(-3); add(-5); add(-3); add(-6); add(-6); add(-6);
			}
		});
		arr3.add(new ArrayList<>() {
			{
				add(-3); add(-6); add(0); add(-8); add(-6); add(-7);
			}
		});
		System.out.println();
		System.out.println(hourglassSum(arr3));
	}

	/*
	 * -9 -9 -9  1 1 1 
	 *  0 -9  0  4 3 2
	-*  9 -9 -9  1 2 3
	 *  0  0  8  6 6 0
	 *  0  0  0 -2 0 0
	 *  0  0  1  2 4 0
	 */
	public static int hourglassSum(List<List<Integer>> arr) {
		int columnSize = arr.size();
		int rowSize = arr.get(0).size();
		int maxSum = -9999;

		List<Integer> currRow;
		for (int i = 0; i < columnSize - 2; i++) {
			int localSum;
			
			for (int j = 0; j < rowSize - 2; j++) {
				localSum = 0;

				currRow = arr.get(i);
				for (int k = 0; k < 3; k++) {
					localSum += currRow.get(j + k);
				}

				currRow = arr.get(i + 1);
				localSum += currRow.get(j + 1);

				currRow = arr.get(i + 2);
				for (int k = 0; k < 3; k++) {
					localSum += currRow.get(j + k);
				}

				maxSum = Math.max(maxSum, localSum);
			}
		}
		return maxSum;
	}
}
