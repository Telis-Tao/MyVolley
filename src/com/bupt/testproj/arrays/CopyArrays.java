package com.bupt.testproj.arrays;

import java.util.Arrays;
import java.util.List;

public class CopyArrays {
	public static void main(String[] args) {
		String[] strs = new String[] { "123", "456", "789" };
		System.out.println(Arrays.toString(strs));
		String[] copies = Arrays.copyOf(strs, strs.length);
		copies[1] = "654";
		System.out.println(Arrays.toString(copies));
		List<String> anotherCopies = Arrays.asList(strs);
		System.out.println(anotherCopies);
		anotherCopies.set(1, "654");
		System.out.println(anotherCopies);
		Object[] array = anotherCopies.toArray();
		System.out.println(Arrays.toString(array));
	}
}
