package com.ds.problems;

import org.junit.Assert;
import org.junit.Test;

public class ShuffleString_1528 {
	
	/*
	 * Leet Code Link : https://leetcode.com/problems/shuffle-string/
	 * Leet Code Problem Number :1528. Shuffle String
	 * 
	 * You are given a string s and an integer array indices of the same length. The string s will 
	 * be shuffled such that the character at the ith position moves to indices[i] in the shuffled 
	 * string. 
	 * 
	 * Return the shuffled string.
	 */

	@Test
	public void test1() { // Positive
		Assert.assertTrue(restoreString("codeleet", new int[] { 4, 5, 6, 7, 0, 2, 1, 3 }).equals("leetcode"));
	}

	@Test
	public void test2() { // Negative
		Assert.assertTrue(restoreString("abc", new int[] { 0, 1, 2 }).equals("abc"));
	}

	@Test
	public void test3() { // Edge
		Assert.assertTrue(restoreString("cab", new int[] { 2, 0, 1 }).equals("abc"));
	}

	/*
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public String restoreString(String s, int[] indices) {

		StringBuilder sb = new StringBuilder(s);

		for (int i = 0; i < s.length(); i++) {
			sb.setCharAt(indices[i], s.charAt(i));
		}

		return sb.toString();
	}

	/*
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public String restoreString2(String s, int[] indices) {

		char out[] = new char[indices.length];
		
		for (int i = 0; i < indices.length; i++) {
			out[indices[i]] = s.charAt(i);
		}
		
		return new String(out);
	}

	/*
	 * Time Complexity: O(n^2) 
	 * Space Complexity: O(1)
	 */
	public String restoreString3(String s, int[] indices) {
		
		char[] charArr = s.toCharArray();

		for (int i = 0; i < indices.length; i++) {
			while (i != indices[i]) {
				swap(charArr, i, indices[i]);
				swap(indices, i, indices[i]);
			}
		}
		
		return String.valueOf(charArr);
	}

	public void swap(int[] arr, int x, int y) {

		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public void swap(char[] arr, int x, int y) {

		char temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
