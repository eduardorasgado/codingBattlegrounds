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
				//add(1); add(2); add(1); add(2); add(1); add(3); add(2);
				add(1); add(1); add(3); add(1); add(2); add(1); add(3); add(3); add(3); add(3);
			}
		};
		
		System.out.println("Result: " + sockMerchant(7, myArr));	
	}
	
	/*
	 * 1 1 3 1 2 1 3 3 3 3
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
		int pairs = 0;
        Map<Integer, Integer> repMap = new HashMap<>();
        
        for(Integer sock : ar) {
        	if(repMap.containsKey(sock)) {
        		repMap.replace(sock, repMap.get(sock) + 1);
        	} else {
        		repMap.put(sock, 1);
        	}
        }
        
        for(var entry : repMap.entrySet()) {
        	pairs += entry.getValue() / 2;
        }
        return pairs;
    }

}
