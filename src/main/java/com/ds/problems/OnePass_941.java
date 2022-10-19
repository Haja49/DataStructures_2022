package com.ds.problems;

import org.junit.Assert;
import org.junit.Test;

public class OnePass_941 {
	
	/*
	 * Leet Code Link : https://leetcode.com/problems/valid-mountain-array/
	 * Leet Code Problem Number : 941. Valid Mountain Array
	 * 
	 * Given an array of integers arr, return true if and only if it is a valid mountain array.
	 * 
	 * 	Recall that arr is a mountain array if and only if:
	 * 		arr.length >= 3
	 * 		There exists some i with 0 < i < arr.length - 1 such that:
	 * 			arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
	 * 			arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
	 */

	@Test
	public void test1() { // Positive
		int[] input = { 2, 1 };
		Assert.assertFalse(validMountainArray(input));
	}

	@Test
	public void test2() { // Negative
		int[] input = { 3, 5, 5 };
		Assert.assertFalse(validMountainArray(input));
	}

	@Test
	public void test3() { // Edge
		int[] input = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Assert.assertFalse(validMountainArray(input));
	}

	/*
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public boolean validMountainArray(int[] arr) {

		int i = 0;
		while (i < arr.length - 1 && arr[i] < arr[i + 1])
			i++;

		if (i == 0 || i == arr.length - 1)
			return false;

		while (i < arr.length - 1 && arr[i] > arr[i + 1])
			i++;

		return i == arr.length - 1;
	}

	/*
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public boolean validMountainArray2(int[] arr) {

		int i = 0;
		while (i < arr.length - 1 && arr[i] < arr[i + 1])
			i++;

		int j = arr.length - 1;
		while (j > 0 && arr[j - 1] > arr[j])
			j--;

		return i > 0 && i == j && j < arr.length - 1;
	}

	/*
	 * Time Complexity: O(n/2) --> O(n) 
	 * Space Complexity: O(1)
	 */
	public boolean validMountainArray3(int[] arr) {
		int i = 0;
		int j = arr.length - 1;

		while (i < j) {
			if (arr[i + 1] > arr[i]) {
				i++;
			} else if (arr[j - 1] > arr[j]) {
				j--;
			} else {
				break;
			}
		}

		return i > 0 && i == j && j < arr.length - 1;
	}
}
