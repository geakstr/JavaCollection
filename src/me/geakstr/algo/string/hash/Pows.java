package me.geakstr.algo.string.hash;

import java.util.ArrayList;

class Pows {
	private static ArrayList<Integer> p1 = null, p2 = null;
	private static Pair pair = null;

	public static Pair get(int n, int w1, int m1, int w2, int m2) {
		int size = p1 == null ? 0 : p1.size();
		int start = size;
		if (p1 == null || size == 0) {
			start = 1;
			pair = new Pair();
			p1 = new ArrayList<Integer>();
			p2 = new ArrayList<Integer>();
			p1.add(start);
			p2.add(start);
		}
		if (n >= size) {
			for (int i = start; i <= n; ++i) {
				p1.add((int) ((long) p1.get(i - 1) * w1 % m1));
				p2.add((int) ((long) p2.get(i - 1) * w2 % m2));
			}
			pair.a = p1;
			pair.b = p2;
		}
		return pair;
	}

}