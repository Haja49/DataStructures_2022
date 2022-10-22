package com.ds.problems;

import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

public class RemoveStones_1962 {

	@Test
	public void test1() { // Positive
		int[] piles = { 5, 4, 9 };
		int k = 2;
		Assert.assertEquals(12, minStoneSum(piles, k));
	}

	@Test
	public void test2() { // Negative
		int[] piles = { 5 };
		int k = 1;
		Assert.assertEquals(3, minStoneSum(piles, k));
	}

	@Test
	public void test3() { // Edge
		int[] piles = { 4, 3, 6, 7 };
		int k = 3;
		Assert.assertEquals(12, minStoneSum(piles, k));
	}

	public int minStoneSum(int[] piles, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		int res = 0;

		for (int pile : piles) {
			pq.add(pile);
			res += pile;
		}

		while (k-- > 0) {
			int a = pq.poll();
			pq.add(a - a / 2);
			res -= a / 2;
		}

		return res;
	}
}
