package com.hackerrank.interviewPreparationKit.warmUpChallenges;

import java.util.ArrayList;

public class CountingValleys {
	
	/**
	 * [D D U U U U D D]
	 * 
	 *             U
	 *           U   D
	 * [       U       D ]
	 * 	 D   U
	 *     D
	 *     
	 *  
	 *  {
	 *    D
	 *    U
	 *  }
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countingValleys(8, "DDUUUUDD")); // 1
		System.out.println(countingValleys(8, "UDDDUDUU")); // 1
	}
	
	public static int countingValleys(int steps, String path) {		
		String[] pathArr = path.split("");
		int valleysCount = 0;
		
		int altitude = 0;
		int lastAltitude = 0;
		
		for(int i = 0; i < steps; i++) {
			lastAltitude = altitude;
			
			if(pathArr[i].equals("U")) {
				//
				altitude++;
			} 
			
			else if(pathArr[i].equals("D")) {
				altitude--;
			}
			
			if(lastAltitude == -1 && altitude == 0) {
				valleysCount++;
			}
		}
		
		return valleysCount;
	}
}
