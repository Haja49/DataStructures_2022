package com.ds.problems;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class PartitionArrayAccordingToPivot_2161 {
	
	/*
	 * LeetCode Link : https://leetcode.com/problems/partition-array-according-to-given-pivot/
	 * LeetCode Problem Number: 2161. Partition Array According to Given Pivot
	 * 
	 * You are given a 0-indexed integer array nums and an integer pivot. 
	 * Rearrange nums such that the following conditions are satisfied:
	 * 		Every element less than pivot appears before every element greater 
	 * 		than pivot.
	 * 		Every element equal to pivot appears in between the elements less than 
	 * 		and greater than pivot.
	 * 		The relative order of the elements less than pivot and the elements 
	 * 		greater than pivot is maintained.
	 * 			More formally, consider every pi, pj where pi is the new position 
	 * 			of the ith element and pj is the new position of the jth element. 
	 * 			For elements less than pivot, if i < j and nums[i] < pivot and 
	 * 			nums[j] < pivot, then pi < pj. Similarly for elements greater than 
	 * 			pivot, if i < j and nums[i] > pivot and nums[j] > pivot, then 
	 * 			pi < pj.
	 * Return nums after the rearrangement.
	 */

	@Test
	public void test1() { // Positive
		Assert.assertTrue(Arrays.equals(pivotArray(new int[] { 9, 12, 5, 10, 14, 3, 10 }, 10),
				new int[] { 9, 5, 3, 10, 10, 12, 14 }));
	}

	@Test
	public void test2() { // Negative
		Assert.assertTrue(Arrays.equals(pivotArray(new int[] { 1 }, 2), new int[] { 1 }));
	}

	@Test
	public void test3() { // Edge
		Assert.assertTrue(Arrays.equals(pivotArray(new int[] { -3, 4, 3, 2 }, 2), new int[] { -3, 2, 4, 3 }));
	}

	/*
	 * Time Complexity: O(2n) --> O(n)
	 * Space Complexity: O(n)
	 */
	public int[] pivotArray(int[] nums, int pivot) {

		int[] out = new int[nums.length];
		int j = 0;
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < pivot)
				out[j++] = nums[i];
			if (nums[i] == pivot)
				count++;
		}

		while (count > 0) {
			out[j++] = pivot;
			count--;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > pivot)
				out[j++] = nums[i];
		}

		return out;
	}

	/*
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public int[] pivotArray2(int[] nums, int pivot) {

		int[] out = new int[nums.length];
		int left = 0;
		int right = nums.length - 1;

		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] < pivot)
				out[left++] = nums[i];
			if (nums[nums.length - 1 - i] > pivot)
				out[right--] = nums[nums.length - 1 - i];
		}

		while (left <= right) {
			out[left++] = pivot;
		}

		return out;
	}
}
