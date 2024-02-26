package com.hackerrank.interviewPreparationKit.DictionariesAndHashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// link: https://www.hackerrank.com/challenges/ctci-ransom-note/problem
public class HashTablesRansomNote {

	public static void main(String[] args) {
		List<String> magazineList = Arrays.asList("give me one grand today night".split(" "));
		List<String> noteList = Arrays.asList("give one grand today".split(" "));
		checkMagazine(magazineList, noteList); // Yes
		
		magazineList = Arrays.asList("two times three is not four".split(" "));
		noteList = Arrays.asList("two times two is four".split(" "));
		checkMagazine(magazineList, noteList); // No
		
		magazineList = Arrays.asList("ive got a lovely bunch of coconuts".split(" "));
		noteList = Arrays.asList("ive got some coconuts".split(" "));
		checkMagazine(magazineList, noteList); // No
	}

	public static void checkMagazine(List<String> magazine, List<String> note) {
		HashMap<String, Integer> noteMap = new HashMap<>();
		
		note.stream().forEach(word -> {
			int wordCount = noteMap.get(word) != null ? noteMap.get(word) + 1 : 1;
			noteMap.put(word, wordCount);
		});
		
		magazine.stream().forEach(magWord -> {
			noteMap.computeIfPresent(magWord, (key, value) -> value - 1);
		});
		
		for(Integer value : noteMap.values()) {
			if(value > 0) {
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
	}
}
