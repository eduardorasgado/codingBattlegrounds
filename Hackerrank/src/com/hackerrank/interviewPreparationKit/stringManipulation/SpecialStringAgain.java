package com.hackerrank.interviewPreparationKit.stringManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

// link: https://www.hackerrank.com/challenges/special-palindrome-again/problem
public class SpecialStringAgain {

	public static void main(String[] args) {
		// 7
		System.out.println(substrCount(5, "asasd"));
		// 10
		System.out.println(substrCount(7, "abcbaba"));
		// 10
		System.out.println(substrCount(4, "aaaa"));
		// 12
		System.out.println(substrCount(8, "mnonopoo"));
	}
	
	// naive implementation
	public static long substrCount(int n, String s) {
 		int specialStrCount = n;
		
		int i = 0;
		int j = 0;
		int k = 2;
		
		while(k <= n) {
			i = 0;
			j = k;
			
			while(j <= n) {
				String[] wordArr = s.substring(i, j).split("");
				HashMap<String, List<Integer>> wordMap = new HashMap<>();
				
				List<Integer> currList;
				for(int q = 0; q < wordArr.length; q++) {
					String currLetter = wordArr[q];
					
					if(wordMap.containsKey(currLetter)) {
						currList = wordMap.get(currLetter);						
					} else {
						currList = new ArrayList<>();
					}
					
					currList.add(q + 1);
					wordMap.put(currLetter, currList);
					
				}
				
				int diffLettersInWord = wordMap.keySet().size();
				
				if (diffLettersInWord == 1) {
					++specialStrCount;
				} else if(diffLettersInWord == 2 && wordArr.length > 2 && wordArr.length % 2 != 0){
					Optional<List<Integer>> listOfOneElement = wordMap.values().stream()
							.filter(positionList -> positionList.size() == 1)
							.findFirst();
					
					if(listOfOneElement.isPresent() && listOfOneElement.get().get(0) == (wordArr.length / 2) + 1) {
						++specialStrCount;
					}
				}
				
				++i;
				++j;
			}
			
			++k;
		}
		
		return specialStrCount;
    }
}
