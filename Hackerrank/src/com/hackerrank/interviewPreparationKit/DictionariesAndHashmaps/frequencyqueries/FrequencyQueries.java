package com.hackerrank.interviewPreparationKit.DictionariesAndHashmaps.frequencyqueries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// link: https://www.hackerrank.com/challenges/frequency-queries/problem
public class FrequencyQueries {

	public static void main(String[] args) {
		// 1 5
		// 1 6
		// 3 2
		// 1 10
		// 1 10
		// 1 6
		// 2 5
		// 3 2
		// output: [0, 1]
		List<List<Integer>> queries1 = new ArrayList<>() {{
			add(new ArrayList<>() {{ add(1); add(5); }});
			add(new ArrayList<>() {{ add(1); add(6); }});
			add(new ArrayList<>() {{ add(3); add(2); }});
			add(new ArrayList<>() {{ add(1); add(10); }});
			add(new ArrayList<>() {{ add(1); add(10); }});
			add(new ArrayList<>() {{ add(1); add(6); }});
			add(new ArrayList<>() {{ add(2); add(5); }});
			add(new ArrayList<>() {{ add(3); add(2); }});
		}};
		
		// 3 4
		// 2 1003
		// 1 16
		// 3 1
		// output: [0, 1]
		List<List<Integer>> queries2 = new ArrayList<>() {{
			add(new ArrayList<>() {{ add(3); add(4); }});
			add(new ArrayList<>() {{ add(2); add(1003); }});
			add(new ArrayList<>() {{ add(1); add(16); }});
			add(new ArrayList<>() {{ add(3); add(1); }});
		}};
		
		// 1 3
		// 2 3
		// 3 2
		// 1 4
		// 1 5
		// 1 5
		// 1 4
		// 3 2
		// 2 4
		// 3 2
		// output: [0, 1, 1]
		List<List<Integer>> queries3 = new ArrayList<>() {{
			add(new ArrayList<>() {{ add(1); add(3); }});
			add(new ArrayList<>() {{ add(2); add(3); }});
			add(new ArrayList<>() {{ add(3); add(2); }});
			add(new ArrayList<>() {{ add(1); add(4); }});
			add(new ArrayList<>() {{ add(1); add(5); }});
			add(new ArrayList<>() {{ add(1); add(5); }});
			add(new ArrayList<>() {{ add(1); add(4); }});
			add(new ArrayList<>() {{ add(3); add(2); }});
			add(new ArrayList<>() {{ add(2); add(4); }});
			add(new ArrayList<>() {{ add(3); add(2); }});
		}};
		
		System.out.println(freqQuery(queries1));
		System.out.println(freqQuery(queries2));
		System.out.println(freqQuery(queries3));
		
		//var lgTest = new FrequencyQueriesTestCase1();
		//System.out.println(freqQuery(stringToList(lgTest.getTcLarge())));
		//var lgTest2 = new FrequencyQueriesTestCase2();
		//System.out.println(freqQuery(stringToList(lgTest2.getTcLarge())));
	}
	
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		HashMap<Integer, Integer> occurenceMap = new HashMap<>();
		HashMap<Integer, Integer> currCountMap = new HashMap<>();
		List<Integer> resultList = new ArrayList<>();
		
		for(List<Integer> query : queries) {
			int currNumber = query.get(1);
			
			switch(query.get(0) - 1) {
			case 0:
				addOccurence(occurenceMap, currNumber, currCountMap);
				break;
				
			case 1:
				removeOccurence(occurenceMap, currNumber, currCountMap);
				break;
				
			case 2:
				if(currCountMap.get(currNumber) != null && currCountMap.get(currNumber) > 0) {
					resultList.add(1);
				} else {
					resultList.add(0);
				}
				break;
			}
		}
		
		return resultList;
    }
	
	static void addOccurence(HashMap<Integer, Integer> occurenceMap, int currNumber, 
			HashMap<Integer, Integer> currCountMap) {
		int occurence = 0;
		Integer oldOccurence = null;
		
		if(occurenceMap.containsKey(currNumber)) {
			oldOccurence = occurenceMap.get(currNumber);
			occurence = oldOccurence + 1;
		} else {
			occurence = 1;
		}
		
		occurenceMap.put(currNumber, occurence);
		updateOccurenceMap(currNumber, oldOccurence, currCountMap, false);
		updateOccurenceMap(currNumber, occurence, currCountMap, true);
	}
	
	static void removeOccurence(HashMap<Integer, Integer> occurenceMap, int currNumber, 
			HashMap<Integer, Integer> currCountMap) {
		int occurence = 0;
		Integer oldOccurence = null;
		
		if(occurenceMap.containsKey(currNumber)) {
			oldOccurence = occurenceMap.get(currNumber);
			occurence = (oldOccurence - 1 >= 0) ? oldOccurence - 1 : 0;
			
			occurenceMap.put(currNumber, occurence);
			updateOccurenceMap(currNumber, oldOccurence, currCountMap, false);
			updateOccurenceMap(currNumber, occurence, currCountMap, true);
		}
	}
	
	static void updateOccurenceMap(int currNumber, Integer occurence, 
			HashMap<Integer, Integer> currCountMap, boolean isAdding) {
		if(occurence != null) {
			Integer count = currCountMap.containsKey(occurence) ? currCountMap.get(occurence) : 0;
			
			if(isAdding) {
				currCountMap.put(occurence, count + 1);
			} else {
				currCountMap.put(occurence, count - 1);
			}
		}
	}
	
	private static List<List<Integer>> stringToList(String stringList) {
		return Arrays.stream(stringList.split("\\r\\n"))
			.map(String::trim)
			.map(textPair -> 
				Arrays.stream(textPair.split(" "))
					.map(Integer::parseInt)
					.toList())
			.toList();
	}
}
