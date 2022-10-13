package com.ds.problems;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class DestroyingAsteriods_2126 {
	
	/*
	 * Leet Code Link : https://leetcode.com/problems/destroying-asteroids/
	 * Leet Code Problem Number : 2126. Destroying Asteroids
	 * 
	 * You are given an integer mass, which represents the original mass of a planet. You are 
	 * further given an integer array asteroids, where asteroids[i] is the mass of the ith asteroid.
	 * 
	 * You can arrange for the planet to collide with the asteroids in any arbitrary order. If the 
	 * mass of the planet is greater than or equal to the mass of the asteroid, the asteroid is 
	 * destroyed and the planet gains the mass of the asteroid. Otherwise, the planet is destroyed.
	 * 
	 * Return true if all asteroids can be destroyed. Otherwise, return false.
	 */

	@Test
	public void testData01() { // Positive
		int mass = 10;
		int[] asteroids = { 3, 9, 19, 5, 21 };
		Assert.assertEquals(true, asteroidsDestroyed(mass, asteroids));
	}

	@Test
	public void testData02() { // Negative
		int mass = 5;
		int[] asteroids = { 4, 9, 23, 4 };
		Assert.assertEquals(false, asteroidsDestroyed(mass, asteroids));
	}

	@Test
	public void testData03() { // Edge
		int mass = 1;
		int[] asteroids = { 1 };
		Assert.assertEquals(true, asteroidsDestroyed(mass, asteroids));

	}

	/*
	 * Time Complexity: O(n logn) 
	 * Space Complexity: O(n)
	 */
	public boolean asteroidsDestroyed(int mass, int[] asteroids) {
		
		Arrays.sort(asteroids);
		long m = mass;
		
		for (int i = 0; i < asteroids.length; i++) {
			if (m < asteroids[i]) {
				return false;
			}
			m += asteroids[i];
		}
		
		return true;
	}
}
