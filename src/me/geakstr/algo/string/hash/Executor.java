package me.geakstr.algo.string.hash;

public class Executor {
	public static void main(String[] args) {
		String s1 = "sstringg";
		String s2 = "string";
		String s3 = "string";
		String s4 = "stringgggggg";

		Hash h1 = new Hash(s1);
		Hash h2 = new Hash(s2);
		Hash h3 = new Hash(s3);
		Hash h4 = new Hash(s4);

		System.out.println(h1.hash(1, 6));
		System.out.println(h2.hash());
		System.out.println(h3.hash());
		System.out.println(h4.hash(0, 5));
	}
}