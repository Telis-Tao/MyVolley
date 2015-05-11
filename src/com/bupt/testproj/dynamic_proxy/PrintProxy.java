package com.bupt.testproj.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PrintProxy implements InvocationHandler {
	private Object o;

	public Object newInstance(Object o) {
		this.o = o;
		return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(),
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object res = null;
		System.out.println("proxy:");
		res = method.invoke(o, args);
		System.out.println("end proxy");
		return res;
	}

}
