package com.bupt.testproj.multi_patterns;

import java.util.Observer;

public class Test {
	public static void main(String[] args) {
		Observer o = new DuckLogist();
		MacdoalndDuck d = new MacdoalndDuck();
		d.addObserver(o);
		d.quark();
	}
}
