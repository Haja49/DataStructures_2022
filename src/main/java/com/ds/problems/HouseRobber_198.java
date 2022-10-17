package com.ds.problems;

import org.junit.Assert;
import org.junit.Test;

public class HouseRobber_198 {
	
	/*
	 * LeetCode Link : https://leetcode.com/problems/house-robber/
	 * LeetCode Problem Number: 198. House Robber
	 * 
	 * Problem Statement:
	 * You are a professional robber planning to rob houses along a street. Each house has a 
	 * certain amount of money stashed, the only constraint stopping you from robbing each of them 
	 * is that adjacent houses have security systems connected and it will automatically contact 
	 * the police if two adjacent houses were broken into on the same night.
	 * 
	 * Given an integer array nums representing the amount of money of each house, return the 
	 * maximum amount of money you can rob tonight without alerting the police.
     */

	@Test
	public void test1() { // Positive
		int[] nums = { 1, 2, 3, 1 };
		Assert.assertEquals(4, rob(nums));
	}

	@Test
	public void test2() { // Negative
		int[] nums = { 0 };
		Assert.assertEquals(0, rob(nums));
	}

	@Test
	public void test3() { // Edge
		int[] nums = { 2, 7, 9, 3, 1 };
		Assert.assertEquals(12, rob(nums));
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	public int rob(int[] nums) {
		
		if (nums.length == 1)
			return nums[0];
		
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		
		int[] out = new int[nums.length];
		out[0] = nums[0];
		out[1] = nums[1];
		out[2] = nums[0] + nums[2];
		
		for (int i = 3; i < nums.length; i++) {
			out[i] = nums[i] + Math.max(out[i - 2], out[i - 3]);
		}
		
		return Math.max(out[nums.length - 1], out[nums.length - 2]);
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	public int rob2(int[] nums) {
		
		if (nums.length == 1)
			return nums[0];
		
		nums[1] = Math.max(nums[0], nums[1]);
		
		for (int i = 2; i < nums.length; i++) {
			nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
		}
		
		return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
	}
}
