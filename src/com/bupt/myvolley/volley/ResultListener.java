package com.bupt.myvolley.volley;

public interface ResultListener<T> {
	void onResponse(Object o);
	void onError();
}
