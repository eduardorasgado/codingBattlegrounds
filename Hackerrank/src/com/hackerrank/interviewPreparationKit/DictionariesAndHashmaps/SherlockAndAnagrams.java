package com.hackerrank.interviewPreparationKit.DictionariesAndHashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// link: https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
public class SherlockAndAnagrams {

	public static void main(String[] args) {
		// 4
		System.out.println(sherlockAndAnagrams("abba"));
		// 0
		System.out.println(sherlockAndAnagrams("abcd"));
		// 3
		System.out.println(sherlockAndAnagrams("ifailuhkqq"));
		// 10
		System.out.println(sherlockAndAnagrams("kkkk"));
		// 5
		System.out.println(sherlockAndAnagrams("cdcd"));
		// 1464
		System.out.println(sherlockAndAnagrams("dbcfibibcheigfccacfegicigcefieeeeegcghggdheichgafhdigffgifidfbeaccadabecbdcgieaffbigffcecahafcafhcdg"));
		// 166650
		System.out.println(sherlockAndAnagrams("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		// 2134
		System.out.println(sherlockAndAnagrams("fdacbaeacbdbaaacafdfbbdcefadgfcagdfcgbgeafbfbggdedfbdefdbgbefcgdababafgffedbefdecbaabdaafggceffbacgb"));
	}
	
	public static int sherlockAndAnagrams(String s) {
		int anagramCount = 0;
		int textSize = s.length();
		var subMapList = new ArrayList<ArrayList<Map<String, Integer>>>();
		int i = 0;
		int j = 0;
		int k = 1;
		
		while(k < textSize) {
			i = 0;
			j = k;
			
			var subList = new ArrayList<Map<String, Integer>>();
			subMapList.add(subList);
			
			while(j <= textSize) {
				var subMap = new HashMap<String, Integer>();
				
				for(String letter : s.substring(i, j).split("")) {
					int count = subMap.get(letter) == null ? 1 : subMap.get(letter) + 1;
					subMap.put(letter, count);
				}
				
				subList.add(subMap);
				
				++i;
				++j;
			}
			
			++k;
		}
		
		for(var subList : subMapList) {
			for(i = 0; i < subList.size() - 1; i++) {
				
				for(j = i + 1; j < subList.size(); j++) {
					var wordToMatch = copyMap(subList.get(i));
					
					for(var nextWord : subList.get(j).entrySet()) {
						String nWordKey = nextWord.getKey();
						
						if(!wordToMatch.containsKey(nWordKey)) {
							break;
						} else {
							int newCount = wordToMatch.get(nWordKey) - nextWord.getValue();
							wordToMatch.put(nWordKey, newCount);
						}
					}
					
					if(wordToMatch.values().stream().allMatch(value -> value == 0)) {
						++anagramCount;
					}
				}
			}
		}
		
		return anagramCount;
	}
	
	private static Map<String, Integer> copyMap(Map<String, Integer> map) {
		var copy = new HashMap<String, Integer>();
		
		for(var entry : map.entrySet()) {
			copy.put(entry.getKey(), entry.getValue());
		}
		
		return copy;
	}
}
