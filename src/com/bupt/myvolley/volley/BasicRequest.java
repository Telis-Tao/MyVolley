package com.bupt.myvolley.volley;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.bupt.myvolley.memory_cache.LRUCache;

public class BasicRequest<T> extends AbstractRequest implements Runnable {
	private String url;
	private LRUCache<Integer, T> cache = null;
	public ResultListener listener = null;

	public LRUCache<Integer, T> getCache() {
		return cache;
	}

	public BasicRequest(String url) {
		this(url, new DefaultResultListener());
	}

	public BasicRequest(String url, ResultListener listener) {
		this.url = url;
		this.listener = listener;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicRequest<?> other = (BasicRequest<?>) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public void run() {
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

	public int getKey() {
		// TODO Auto-generated method stub
		return hashCode();
	}

}
