package me.geakstr.algo.string.hash;

public class Executor {
	public static void main(String[] args) {
		String t = "This is the big big text big ololo";

		String p = "big";

		Hash h1 = new Hash(t);
		Hash h2 = new Hash(p);

		int tlen = t.length();
		int plen = p.length();

		for (int l = 0, r = plen - 1; r < tlen; l++, r++) {
			if (h1.hash(l, r) == h2.hash()) {
				System.out.println(l);
			}
		}
	}
}