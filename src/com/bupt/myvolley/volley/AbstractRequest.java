package com.bupt.myvolley.volley;

import java.net.URLConnection;

public abstract class AbstractRequest{
	abstract void openConnection();
	abstract Object onResult(URLConnection conn);
}
