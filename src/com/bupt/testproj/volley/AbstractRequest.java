package com.bupt.testproj.volley;

import java.net.URLConnection;

public abstract class AbstractRequest{
	abstract void openConnection(String url);
	abstract Object onResult(URLConnection conn);
}
