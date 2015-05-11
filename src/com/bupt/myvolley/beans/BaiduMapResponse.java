package com.bupt.myvolley.beans;

import java.util.List;

public class BaiduMapResponse {
	private String status;
	private String message;
	private List<BaiduMapBean> results;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<BaiduMapBean> getResults() {
		return results;
	}

	public void setResults(List<BaiduMapBean> results) {
		this.results = results;
	}
}
