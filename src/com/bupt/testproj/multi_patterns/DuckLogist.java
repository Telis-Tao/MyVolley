package com.bupt.testproj.multi_patterns;

import java.util.Observable;
import java.util.Observer;

public class DuckLogist implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println(o + "just happened!");
	}

}
