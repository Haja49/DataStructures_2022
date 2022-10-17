package com.ds.problems;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindrome_409 {
	
	/*
	 * LeetCode Link : https://leetcode.com/problems/longest-palindrome/
	 * LeetCode Problem Number: 409. Longest Palindrome
	 * 
	 * Given a string s which consists of lowercase or uppercase letters, return 
	 * the length of the longest palindrome that can be built with those letters.
	 * 
	 * Letters are case sensitive, for example, "Aa" is not considered a palindrome 
	 * here.
	 */

	@Test
	public void test1() { // Positive
		String s = "abccccdd";
		Assert.assertTrue(longestPalindrome2(s) == 7);
	}

	@Test
	public void test2() { // Negative
		String s = "a";
		Assert.assertTrue(longestPalindrome(s) == 1);
	}

	@Test
	public void test3() { // Edge
		String s = "bb";
		Assert.assertTrue(longestPalindrome(s) == 2);
	}

	/*
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public int longestPalindrome(String s) {

		Set<Character> set = new HashSet<Character>();
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				set.remove(s.charAt(i));
				count++;
			} else {
				set.add(s.charAt(i));
			}
		}

		return set.isEmpty() ? count * 2 : count * 2 + 1;
	}

	/*
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public int longestPalindrome2(String s) {
		
		int[] arr = new int[128];
		int count = 0;

		for (char ch : s.toCharArray()) {
			if (++arr[ch] == 2) {
				count += 2;
				arr[ch] = 0;
			}
		}

		return count == s.length() ? count : count + 1;
	}
}
