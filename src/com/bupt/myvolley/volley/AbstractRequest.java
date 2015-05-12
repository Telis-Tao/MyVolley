package com.bupt.myvolley.volley;

import java.net.URLConnection;

public abstract class AbstractRequest<T>{
	abstract T onResult(URLConnection conn);
}
