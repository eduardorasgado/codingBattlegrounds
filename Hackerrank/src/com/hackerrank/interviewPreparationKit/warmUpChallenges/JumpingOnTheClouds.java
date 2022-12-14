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
		
		System.out.println(jumpingOnClouds(arr1));
		System.out.println(jumpingOnClouds(arr2));
	}
	
	public static int jumpingOnClouds(List<Integer> c) {
		int minJumps = 0;
		int cloudLen = c.size();
		int currentCloud = 0;		
		boolean endFound = false;
		int stepsForward = 0;
		
		while(!endFound) {
			
			if(currentCloud + 1 <= cloudLen - 1) {
				if(c.get(currentCloud + 1) == 0) {
					stepsForward = 1;
				}
			}
			
			if(currentCloud + 2 <= cloudLen - 1) {
				if(c.get(currentCloud + 2) == 0) {
					stepsForward = 2;
				}
			}
			currentCloud += stepsForward;
			
			++minJumps;
			
			if(currentCloud >= cloudLen - 1) {
				endFound = true;
			}
		}
		
		return minJumps;
	}
}
