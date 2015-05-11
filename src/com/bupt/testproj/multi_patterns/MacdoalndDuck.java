package com.bupt.testproj.multi_patterns;


public class MacdoalndDuck extends Duck implements Quarkable {

	@Override
	public void quark() {
		System.out.println("MacdoalndDuck quark!");
		setChanged();
		notifyObservers();
	}
}
