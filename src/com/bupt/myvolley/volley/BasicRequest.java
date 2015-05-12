package com.bupt.myvolley.volley;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.bupt.myvolley.memory_cache.LRUCache;

public class BasicRequest<T> extends AbstractRequest<Object> implements Runnable {
	private String url;
	private LRUCache<BasicRequest<?>, Object> cache = null;
	public ResultListener<T> listener = null;

	public void setCache(LRUCache<BasicRequest<?>, Object> cache) {
		this.cache = cache;
	}

	public LRUCache<BasicRequest<?>, Object> getCache() {
		return cache;
	}

	public BasicRequest(String url, ResultListener<T> listener) {
		this.url = url;
		this.listener = listener;
	}

	public BasicRequest(String url, ResultListener<T> listener,
			LRUCache<BasicRequest<?>, Object> cache) {
		this.url = url;
		this.listener = listener;
		this.cache = cache;
	}

	/*
	 * needs to be overrided
	 * 
	 * @see
	 * com.bupt.testproj.volley.AbstractRequest#onResult(java.net.URLConnection)
	 */
	@Override
	T onResult(URLConnection conn) {
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
		String httpUrl = "";
		if (!url.startsWith("http://")) {
			httpUrl = "http://" + url;
		}
		URL u = null;
		URLConnection conn = null;
		try {
			u = new URL(httpUrl);
			conn = u.openConnection();
			T t = onResult(conn);
			cache.put(this, t);
			listener.onResponse(t);
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
