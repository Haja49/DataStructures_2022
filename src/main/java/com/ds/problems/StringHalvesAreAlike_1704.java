package com.ds.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class StringHalvesAreAlike_1704 {
	
	/*
	 * LeetCode Link :
	 * https://leetcode.com/problems/determine-if-string-halves-are-alike/ 
	 * LeetCode Problem Number: 1704. Determine if String Halves Are Alike
	 *
	 * Problem Statement You are given a string s of even length. Split this string
	 * into two halves of equal lengths, and let a be the first half and b be the
	 * second half. 
	 * 
	 * Two strings are alike if they have the same number of vowels
	 * ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). 
	 * 
	 * Notice that s contains uppercase and lowercase letters. Return true if a and b are alike. 
	 * Otherwise, return false.
	 */

	@Test
	public void test1() { // Positive
		Assert.assertTrue(halvesAreAlike("book"));
	}

	@Test
	public void test2() { // Negative
		Assert.assertFalse(halvesAreAlike("TextBook"));
	}

	@Test
	public void test3() { // Edge
		Assert.assertTrue(halvesAreAlike("EatPie"));
	}
	
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	private boolean halvesAreAlike(String s) {
		
		String str = "aeiouAEIOU";
		int count = 0;
		
		for (int i = 0; i < s.length() / 2; i++) {
			if (str.indexOf(s.charAt(i)) >= 0) {
				count++;
			}
			if (str.indexOf(s.charAt(i + s.length() / 2)) >= 0) {
				count--;
			}
		}
		
		return count == 0;
	}

	/*
	 * Time Complexity: O(n/2) --> O(n)
	 * Space Complexity: O(1)
	 */
	public boolean halvesAreAlike2(String s) {
		
		Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

		int count = 0, i = 0, j = s.length() - 1;

		while (i < j) {
			if (set.contains(s.charAt(i++)))
				++count;
			if (set.contains(s.charAt(j--)))
				--count;
		}

		return count == 0;
	}
}
