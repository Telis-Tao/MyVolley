package com.bupt.myvolley.volley;

import java.net.URLConnection;

public abstract class AbstractRequest{
	abstract Object onResult(URLConnection conn);
}
