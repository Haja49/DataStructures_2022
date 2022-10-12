package com.ds.problems;

import org.junit.Assert;
import org.junit.Test;

public class CheckAB_2124 {
	
	
	/*
	 * Leet Code Link : https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/
	 * Leet Code Problem Number : 2124. Check if All A's Appears Before All B's
	 * 
	 * Given a string s consisting of only the characters 'a' and 'b', return true if 
	 * every 'a' appears before every 'b' in the string. Otherwise, return false.
	 */

	@Test
	public void test1() { // Positive
		Assert.assertTrue(checkString("aaabbb"));
	}

	@Test
	public void test2() { // Negative
		Assert.assertFalse(checkString("aaa"));
	}

	@Test
	public void test3() { // Edge
		Assert.assertTrue(checkString("aaab"));
	}

	/*
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public boolean checkString(String s) {
		
		for (int i = 1; i < s.length(); ++i) {
			if (s.charAt(i - 1) == 'b' && s.charAt(i) == 'a') {
				return false;
			}
		}
		
		return true;
	}

	/*
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public boolean checkString2(String s) {
		return !s.contains("ba");
	}

	/*
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public boolean checkString3(String s) {

		int index = 0;
		while (index < s.length() && s.charAt(index) == 'a')
			index++;
		while (index < s.length())
			if (s.charAt(index++) == 'a')
				return false;
		
		return true;
	}

	/*
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public boolean checkString4(String s) {
		return s.lastIndexOf('a') < s.indexOf('b') || s.indexOf('b') == -1;
	}
}
