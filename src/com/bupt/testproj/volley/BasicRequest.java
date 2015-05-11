package com.bupt.testproj.volley;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class BasicRequest extends AbstractRequest {

	public BasicRequest(String url) {
		openConnection(url);
	}

	public BasicRequest(String url, ResultListener listener) {
		openConnection(url, listener);
	}

	@Override
	void openConnection(String url) {
		openConnection(url, new DefaultResultListener());
	}

	void openConnection(String url, ResultListener listener) {
		if (!url.startsWith("http://")) {
			url = "http://" + url;
		}
		URL u = null;
		URLConnection conn = null;
		try {
			u = new URL(url);
			conn = u.openConnection();
			Object o = onResult(conn);
			listener.onResponse(o);
		} catch (MalformedURLException e) {
			listener.onError();
			e.printStackTrace();
		} catch (IOException e) {
			listener.onError();
			e.printStackTrace();
		}
	}

	/*
	 * needs to be overrided
	 * 
	 * @see
	 * com.bupt.testproj.volley.AbstractRequest#onResult(java.net.URLConnection)
	 */
	@Override
	Object onResult(URLConnection conn) {
		return null;
	}

}
