package com.hackerrank.interviewPreparationKit.DictionariesAndHashmaps;

import java.util.HashMap;

public class TwoStrings {
	
	public static void main(String[] args) {
		System.out.println(twoStrings("hello", "world")); // YES
		System.out.println(twoStrings("hi", "world")); // NO
	}

	public static String twoStrings(String s1, String s2) {
		HashMap<String, Boolean> subMap = new HashMap<>();
		
		for(int i = 0; i < s1.length(); i++) {
			for(int j = i; j < s1.length(); j++) {
				subMap.put(s1.substring(i, j + 1), true);
			}
		}
		
		for(int i = 0; i < s2.length(); i++) {
			for(int j = i; j < s2.length(); j++) {
				Boolean match = subMap.get(s2.substring(i, j + 1));
				
				if(match != null && match) {
					return "YES";
				}
			}
		}
		
		return "NO";
	}

}
