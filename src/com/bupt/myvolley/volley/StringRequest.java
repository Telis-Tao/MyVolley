package com.bupt.myvolley.volley;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class StringRequest extends BasicRequest<String> {

	public StringRequest(String url, ResultListener<String> listener) {
		super(url, listener);
	}

	@Override
	String onResult(URLConnection conn) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),
					Charset.forName("utf-8")));
			String tmpStr = null;
			StringBuilder result = new StringBuilder();
			while ((tmpStr = br.readLine()) != null) {
				result.append(tmpStr + "\n");
			}
			return result.toString();
		} catch (IOException e) {
			// TODO: handle exception
		}
		return null;
	}
}
