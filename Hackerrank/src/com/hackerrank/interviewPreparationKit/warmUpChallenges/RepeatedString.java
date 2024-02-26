package com.hackerrank.interviewPreparationKit.warmUpChallenges;

import java.util.Objects;

// link: https://www.hackerrank.com/challenges/repeated-string/problem
public class RepeatedString {
	
	public static void main(String[] args) {
		
		// abcacabcac
		System.out.println(repeatedString("abcac", (long) 10)); // 4
		//abaabaabaa
		System.out.println(repeatedString("aba", (long) 10)); // 7
		// aaaaaaaaaaa...
		System.out.println(repeatedString("a", 1000000000000L)); // 1000000000000
	}
	
	public static long repeatedString(String s, long n) {
		long stringLen = s.length();
		long sReps = Math.floorDiv(n, stringLen);
		long portion = Math.floorMod(n, stringLen);
		String[] sArr = s.split("");
		long totalCount = 0;
		long portionCount = 0;
		
		for(int i = 0; i < stringLen; i++) {
			String currLetter = sArr[i];
			
			if(Objects.equals(currLetter, "a")) {
				++totalCount;
				
				if(i + 1 <= portion) {
					++portionCount;
				}
			}
		}
		
		return (totalCount * sReps) + portionCount;
	}
	
}
