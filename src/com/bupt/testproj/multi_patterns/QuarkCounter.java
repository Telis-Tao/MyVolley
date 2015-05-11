package com.bupt.testproj.multi_patterns;

public class QuarkCounter implements Quarkable {
	private static int count = 0;
	private Quarkable q;

	public QuarkCounter(Quarkable q) {
		super();
		this.q = q;
	}

	@Override
	public void quark() {
		// TODO Auto-generated method stub
		count++;
		q.quark();
	}

	public static int getCount() {
		return count;
	}
}
