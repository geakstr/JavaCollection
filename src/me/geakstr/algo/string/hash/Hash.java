package me.geakstr.algo.string.hash;

public class Hash {
	private char[] str;
	private int[] h1, h2;
	private int n, w1, m1, w2, m2;
	private long hash;

	public Hash(char[] str, int w1, int m1, int w2, int m2) {
		this.str = str;
		this.n = str.length;
		this.w1 = w1;
		this.m1 = m1;
		this.w2 = w1;
		this.m2 = m2;
		this.h1 = new int[this.n + 1];
		this.h2 = new int[this.n + 1];
		this.fill_hashes();
		this.hash = hash(0);
	}

	public Hash(String s, int w1, int m1, int w2, int m2) {
		this(s.toCharArray(), w1, m1, w2, m2);
	}

	public Hash(char[] s) {
		this(s, 31, 1000000007, 257, 1000000021);
	}

	public Hash(String s) {
		this(s.toCharArray());
	}

	public long hash(int l, int r) {
		int p1 = Pows.get(n, w1, m1, w2, m2).a.get(r - l + 1);
		int p2 = Pows.get(n, w1, m1, w2, m2).b.get(r - l + 1);
		long a = (h1[l] - 1L * h1[r + 1] * p1 % m1 + m1) % m1;
		long b = (h2[l] - 1L * h2[r + 1] * p2 % m2 + m2) % m2;
		return a << 32L | b;
	}

	public long hash(int l) {
		return hash(l, n - 1);
	}

	public long hash() {
		return hash;
	}

	public int length() {
		return n;
	}

	private void fill_hashes() {
		h1[n - 1] = str[n - 1];
		h2[n - 1] = str[n - 1];
		for (int i = n - 2; i >= 0; --i) {
			h1[i] = (int) ((1L * h1[i + 1] * w1 + str[i]) % m1);
			h2[i] = (int) ((1L * h2[i + 1] * w2 + str[i]) % m2);
		}
	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		for (char ch : str)
			ret.append(ch);
		return ret.toString();
	}
}
