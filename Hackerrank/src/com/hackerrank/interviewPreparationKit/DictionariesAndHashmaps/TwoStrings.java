package com.hackerrank.interviewPreparationKit.DictionariesAndHashmaps;

import java.util.HashMap;

// link: https://www.hackerrank.com/challenges/two-strings/problem
public class TwoStrings {
	
	public static void main(String[] args) {
		System.out.println(twoStrings("hello", "world")); // YES
		System.out.println(twoStrings("hi", "world")); // NO
	}
	
	public static String twoStrings(String s1, String s2) {
		int s1Len = s1.length();
		int s2Len = s2.length();
		String[] s1Arr = s1.split("");
		String[] s2Arr = s2.split("");
		
		HashMap<String, Boolean> subMap = new HashMap<>();
		
		for(int i = 0; i < s1Len; i++) {
			subMap.put(s1Arr[i], true);
		}
		
		for(int i = 0; i < s2Len; i++) {
			Boolean match = subMap.get(s2Arr[i]);
			
			if(match != null && match) {
				return "YES";
			}
		}
		
		return "NO";
	}
}
