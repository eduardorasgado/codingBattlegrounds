package com.hackerrank.interviewPreparationKit.stringManipulation;

import java.util.HashMap;

// link: https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
public class MakingAnagrams {

	public static void main(String[] args) {
		// 4
		System.out.println(makeAnagram("cde", "abc"));
		// 6
		System.out.println(makeAnagram("cdea", "abcaaa"));
		// 2 
		System.out.println(makeAnagram("bacdc", "dcbad"));
	}

	public static int makeAnagram(String a, String b) {
		HashMap<String, Integer> countMap = new HashMap<>();
		int minDeletions = 0;
		String[] aArr = a.split("");
		String[] bArr = b.split("");
		
		for(int i = 0; i < aArr.length; i++) {
			String currLetter = aArr[i];
			countMap.put(currLetter, countMap.containsKey(currLetter) ? countMap.get(currLetter) + 1 : 1);
		}
		
		for(int i = 0; i < bArr.length; i++) {
			String currLetter = bArr[i];
			countMap.put(currLetter, countMap.containsKey(currLetter) ? countMap.get(currLetter) - 1 : -1);
		}
		
		for(int count : countMap.values()) {
			minDeletions += Math.abs(count);
		}
		
		return minDeletions;
	}
}
