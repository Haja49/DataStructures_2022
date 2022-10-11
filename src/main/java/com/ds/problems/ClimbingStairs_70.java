package com.ds.problems;

import org.junit.Assert;
import org.junit.Test;

public class ClimbingStairs_70 {
	
	/*
	 * LeetCode Link : https://leetcode.com/problems/climbing-stairs/
	 * LeetCode Problem Number: 70. Climbing Stairs
	 * 
	 * You are climbing a staircase. It takes n steps to reach the top.
	 * 
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways 
	 * can you climb to the top?
	 */
	
	@Test
    public void test1() { // Positive
        Assert.assertTrue(climbStairs(2)==2);
    }

    @Test
    public void test2() { // Negative
        Assert.assertTrue(climbStairs(1)==1);
    }

    @Test
    public void test3() { // Edge
        Assert.assertTrue(climbStairs(10)==89);
    }

    /*
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public int climbStairs(int n) {

		if (n <= 1) return 1;

		int a = 1;
		int b = 1;

		for (int i = 2; i <= n; i++) {
			int out = a + b;
			a = b;
			b = out;
		}
		
		return b;
	}
}
