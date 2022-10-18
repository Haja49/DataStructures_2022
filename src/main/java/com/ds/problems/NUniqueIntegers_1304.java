package com.ds.problems;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class NUniqueIntegers_1304 {
	
	/*
	 * LeetCode Link : https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
	 * LeetCode Problem Number: 1304. Find N Unique Integers Sum up to Zero
	 * 
	 * Given an integer n, return any array containing n unique integers such that 
	 * they add up to 0.
	 */

	@Test
	public void test1() { // Positive
		Assert.assertTrue(Arrays.equals(sumZero(3), new int[] { 1, 0, -1 }));
	}

	@Test
	public void test2() { // Negative
		Assert.assertTrue(Arrays.equals(sumZero(0), new int[] {}));
	}

	@Test
	public void test3() { // Edge
		Assert.assertTrue(Arrays.equals(sumZero(4), new int[] { 1, 2, -2, -1 }));
	}

	/*
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public int[] sumZero2(int n) {
		int[] out = new int[n];
		
		for (int i = 0; i < n - 1; i += 2) {
			out[i] = i + 1;
			out[i + 1] = -i - 1;
		}
		
		return out;
	}

	/*
	 * Time Complexity: O(n/2) --> O(n) 
	 * Space Complexity: O(n)
	 */
	public int[] sumZero(int n) {
		int[] out = new int[n];
		int left = 0;
		int right = n - 1;
		int start = 1;
		
		while (left < right) {
			out[left++] = start;
			out[right--] = -start++;
		}
		
		return out;
	}

}
