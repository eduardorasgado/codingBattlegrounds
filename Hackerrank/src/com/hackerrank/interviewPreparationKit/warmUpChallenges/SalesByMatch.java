/**
 * 
 */
package com.hackerrank.interviewPreparationKit.warmUpChallenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author Eduardo Rasgado
 *
 */
public class SalesByMatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> myArr = new ArrayList<Integer>()
		{
			private static final long serialVersionUID = 1L;

			{
				add(1); add(2); add(1); add(2); add(1); add(3); add(2);
			}
		};
		
		System.out.println("Result: " + sockMerchant(7, myArr));	
	}
	
	/*
	 * list = {1, 2, 1, 2, 1, 3, 2}
	 * 
	 * {
	 * 	1: 1, 
	 * }
	 * if 
	 * 
	 * pairs = 0
	 * 
	 * */
	public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer, Integer> repetitions = new HashMap<>();        
        int pairs = 0;
        
        for(Integer sock : ar) {
        	if(repetitions.containsKey(sock)) {
        		repetitions.replace(sock, repetitions.get(sock) + 1);
        	} else {
        		repetitions.put(sock, 1);
        	}
        }
		
        Set<Entry<Integer, Integer>> entries = repetitions.entrySet();
        for(Entry<Integer, Integer> entry : entries) {
        	pairs += Math.floor(entry.getValue() / 2);
        }
        
        return pairs;
    }

}
