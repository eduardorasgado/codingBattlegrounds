package com.hackerrank.interviewPreparationKit.stringManipulation;

public class AlternatingCharacters {

	public static void main(String[] args) {
		// 3
		System.out.println(alternatingCharacters("AAAA"));
		// 4
		System.out.println(alternatingCharacters("BBBBB"));
		// 0
		System.out.println(alternatingCharacters("ABABABAB"));
		// 0
		System.out.println(alternatingCharacters("BABABA"));
		// 4
		System.out.println(alternatingCharacters("AAABBB"));
		// 6
		System.out.println(alternatingCharacters("AAABBBAABB"));
		// 4
		System.out.println(alternatingCharacters("AABBAABB"));
		// 1
		System.out.println(alternatingCharacters("ABABABAA"));
	}

	public static int alternatingCharacters(String s) {
		int minDeletions = 0;
		String[] sArr = s.split("");
		String pointer = sArr[0];
		
		for(int i = 1; i < sArr.length; i++) {
			if(!pointer.equals(sArr[i])) {
				pointer = sArr[i];
			} else {
				++minDeletions;
			}
		}
		
		return minDeletions;
	}
}
