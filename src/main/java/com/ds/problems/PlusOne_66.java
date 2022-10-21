package com.ds.problems;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class PlusOne_66 {
	
	/*
	 * Leet Code Link : https://leetcode.com/problems/plus-one/
	 * Leet Code Problem Number :66. Plus One
	 * 
	 * You are given a large integer represented as an integer array digits, where each digits[i] 
	 * is the ith digit of the integer. The digits are ordered from most significant to least 
	 * significant in left-to-right order. The large integer does not contain any leading 0's.
	 * 
	 * Increment the large integer by one and return the resulting array of digits.
	 */

	@Test
	public void testData01() { // Positive
		Assert.assertTrue(Arrays.equals(plusOne(new int[] { 1, 2, 3 }), new int[] { 1, 2, 4 }));
	}

	@Test
	public void testData02() { // Negative
		Assert.assertTrue(Arrays.equals(plusOne(new int[] { 9 }), new int[] { 1, 0 }));
	}

	@Test
	public void testData03() { // Edge
		Assert.assertTrue(Arrays.equals(plusOne(new int[] { 9, 9 }), new int[] { 1, 0, 0 }));
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	public int[] plusOne(int[] digits) {
		
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				digits[i]++;
				break;
			} else {
				digits[i] = 0;
			}
		}
		
		if (digits[0] == 0) {
			int[] out = new int[digits.length + 1];
			out[0] = 1;
			return out;
		}
		
		return digits;
	}
	
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	public int[] plusOne2(int[] digits) {
		
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i]++;
			if (digits[i] <= 9)
				return digits;
			digits[i] = 0;
		}
		
		int[] out = new int[digits.length + 1];
		out[0] = 1;
		
		return out;
	}
}
