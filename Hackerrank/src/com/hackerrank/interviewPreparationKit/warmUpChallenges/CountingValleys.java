package com.hackerrank.interviewPreparationKit.warmUpChallenges;

import java.util.Arrays;
import java.util.Objects;

// link: https://www.hackerrank.com/challenges/counting-valleys/problem
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
	 * [ U D D D U D U U]
	 * 
	 *   U
	 * [   D           U
	 *       D   U   U
	 *         D  D 
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
		System.out.println(countingValleys(12, "DDUUDDUDUUUD")); // 2
	}
	
	public static int countingValleys(int steps, String path) {
		int valleys = 0;
		boolean intoTheValley = false;
		boolean outTheValley = false;
		int seaLevel = 0;
		int currentLevel = seaLevel;
		
		for(String pathElement : Arrays.asList(path.split(""))) {
			if(Objects.equals(pathElement, "D")) {
				if(currentLevel == seaLevel) {
					intoTheValley = true;
				}
				currentLevel -= 1;
			}
			
			else if(Objects.equals(pathElement, "U")) {
				if(intoTheValley == true && currentLevel + 1 == seaLevel) {
					outTheValley = true;
				}
				currentLevel += 1;
			}
			
			if(intoTheValley && outTheValley) {
				intoTheValley = false;
				outTheValley = false;
				valleys += 1;
			}
		}
		
		return valleys;
	}
}
