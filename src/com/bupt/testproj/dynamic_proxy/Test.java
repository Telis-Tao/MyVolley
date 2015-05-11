package com.bupt.testproj.dynamic_proxy;

public class Test {
	public static void main(String[] args) {
		Printable p = (Printable) new PrintProxy().newInstance(new Print());
		p.print();
	}
}
