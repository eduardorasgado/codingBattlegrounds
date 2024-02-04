package com.hackerrank.interviewPreparationKit.warmUpChallenges;

import java.util.ArrayList;
import java.util.List;

public class JumpingOnTheClouds {
	
	/*                 
	 * [ 0 1 0 0 0 1 0]
	 * 
	 */
	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<>() {
			{
				add(0); add(1); add(0); add(0); add(0); add(1); add(0);
			}
		};
		
		ArrayList<Integer> arr2 = new ArrayList<>() {
			{
				add(0); add(0); add(1); add(0); add(0); add(1); add(0);
			}
		};
		
		System.out.println(jumpingOnClouds(arr1)); // 3
		System.out.println(jumpingOnClouds(arr2)); // 4
	}
	
	public static int jumpingOnClouds(List<Integer> c) {
		int jumpCount = 0;
		int currPos = 0;
		int pathLen = c.size();
		boolean alreadyJumped;
		
		while(currPos < pathLen - 1) {
			alreadyJumped = false;
			
			if(currPos + 2 < pathLen) {
				if(c.get(currPos + 2) == 0) {
					currPos += 2;
					alreadyJumped = true;
				}
			}
			
			if(!alreadyJumped && currPos + 1 < pathLen) {
				if(c.get(currPos + 1) == 0) {
					currPos += 1;
				}
			}
			
			++jumpCount;
		}
		
		return jumpCount;
	}
}
