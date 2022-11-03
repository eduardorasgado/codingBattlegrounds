package com.hackerrank.interviewPreparationKit.warmUpChallenges;

public class RepeatedString {
	
	public static void main(String[] args) {
		
		// abcacabcac
		System.out.println(repeatedString("abcac", (long) 10));
		
		System.out.println(repeatedString("aba", (long) 10));

		System.out.println(repeatedString("a", 1000000000000L));
	}
	
	public static long repeatedString(String s, long n) {
		long aLetterTotalTimes = 0L;
		long sLength = s.length();
		long sTimes = n / sLength;
		long residual = n % sLength;
		
		long aLetterTimesInWord = 0L;
		for(int i = 0; i < sLength; i++) {
			
			if(s.charAt(i) == 'a') {
				++aLetterTimesInWord;
			}
		}
		
		aLetterTotalTimes = aLetterTimesInWord * sTimes;
		
		long aSubGroupAddition = 0L;
		for(int i = 0; i < residual; i++) {
			
			if(s.charAt(i) == 'a') {
				++aSubGroupAddition;
			}
		}
		
		aLetterTotalTimes += aSubGroupAddition;
		
		return aLetterTotalTimes;
	}
	
}
