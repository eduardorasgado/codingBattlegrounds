package com.hackerrank.interviewPreparationKit.Arrays;

import java.util.ArrayList;
import java.util.List;

// link: https://www.hackerrank.com/challenges/2d-array/problem
public class TwoDArrayDs {

	public static void main(String[] args) {
		/*
		 * -9 -9 -9  1 1 1 
		 *  0 -9  0  4 3 2
		-* -9 -9 -9  1 2 3
		 *  0  0  8  6 6 0
		 *  0  0  0 -2 0 0
		 *  0  0  1  2 4 0
		 */
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
		
		System.out.println(hourglassSum(arr)); // 28
		
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
		
		// 1 1 1 0 0 0
		// 0 1 0 0 0 0
		// 1 1 1 0 0 0
		// 0 0 2 4 4 0
		// 0 0 0 2 0 0
		// 0 0 1 2 4 0
		
		List<List<Integer>> arr4 = new ArrayList<>();
		
		arr4.add(new ArrayList<>() {
			{
				add(1); add(1); add(1); add(0); add(0); add(0);
			}
		});
		arr4.add(new ArrayList<>() {
			{
				add(0); add(1); add(0); add(0); add(0); add(0);
			}
		});
		arr4.add(new ArrayList<>() {
			{
				add(1); add(1); add(1); add(0); add(0); add(0);
			}
		});
		arr4.add(new ArrayList<>() {
			{
				add(0); add(0); add(2); add(4); add(4); add(0);
			}
		});
		arr4.add(new ArrayList<>() {
			{
				add(0); add(0); add(0); add(2); add(0); add(0);
			}
		});
		arr4.add(new ArrayList<>() {
			{
				add(0); add(0); add(1); add(2); add(4); add(0);
			}
		});
		System.out.println();
		System.out.println(hourglassSum(arr4)); // 19
	}

	
	public static int hourglassSum(List<List<Integer>> arr) {
		int height = arr.size();
		int width = arr.get(0).size();		
		int maxSum = -9999;
		
		for(int i = 0; i < height - 2;i++) {
			for(int j = 0; j < width - 2; j++) {
				int currSum = 0;
				currSum += arr.get(i).get(j);
				currSum += arr.get(i).get(j + 1);
				currSum += arr.get(i).get(j + 2);
				
				currSum += arr.get(i + 1).get(j + 1);
				
				currSum += arr.get(i + 2).get(j);
				currSum += arr.get(i + 2).get(j + 1);
				currSum += arr.get(i + 2).get(j + 2);
				
				if(currSum > maxSum) {
					maxSum = currSum;
				}
			}
		}
		
		return maxSum;
	}
}
