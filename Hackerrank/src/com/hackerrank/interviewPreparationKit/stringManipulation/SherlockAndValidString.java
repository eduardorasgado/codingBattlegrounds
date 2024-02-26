package com.hackerrank.interviewPreparationKit.stringManipulation;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

// link: https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
public class SherlockAndValidString {

	public static void main(String[] args) {
		// YES
		System.out.println(isValid("abc"));
		// YES
		System.out.println(isValid("abcc"));
		// NO
		System.out.println(isValid("abccc"));
		// NO
		System.out.println(isValid("aabbcd"));
		// NO
		System.out.println(isValid("aabbccddeefghi"));
		// YES
		System.out.println(isValid("abcdefghhgfedecba"));
		// YES
		System.out.println(isValid(getLargeTc1()));
	}

	public static String isValid(String s) {
		HashMap<String, Integer> countItemsMap = new HashMap<>();
		HashMap<Integer, Integer> valuesMap = new HashMap<>();
		String[] sArr = s.split("");
		
		for (int i = 0; i < sArr.length; i++) {
			String currLetter = sArr[i];
			countItemsMap.put(currLetter, countItemsMap.containsKey(currLetter) ? countItemsMap.get(currLetter) + 1 : 1);
		}
		
		for(Integer value : countItemsMap.values()) {
			valuesMap.put(value, valuesMap.containsKey(value) ? valuesMap.get(value) + 1 : 1);
		}
		
		List<Integer> keyList = valuesMap.keySet().stream().collect(Collectors.toList());
		if(keyList.size() == 1) {
			return "YES";
		} else if(keyList.size() == 2) {
			if(Math.abs(keyList.get(0) - keyList.get(1)) > 1
					// one element repeated one time
					&& ((keyList.get(0) == 1 && valuesMap.get(keyList.get(0)) == 1) 
							|| (valuesMap.get(keyList.get(1)) == 1 && keyList.get(1) == 1))) {
				return "YES";
			}
			
			if(Math.abs(keyList.get(0) - keyList.get(1)) == 1 
					&& (valuesMap.get(keyList.get(0)) == 1 || valuesMap.get(keyList.get(1)) == 1)) {
				return "YES";
			}
		}
		
		return "NO";
	}
	
	private static String getLargeTc1() {
		return "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
	}
}
