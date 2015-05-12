package com.bupt.myvolley.volley;

public interface ResultListener<T extends Object> {
	void onResponse(Object o);
	void onError();
}
