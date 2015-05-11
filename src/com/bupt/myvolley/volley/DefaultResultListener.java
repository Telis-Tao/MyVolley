package com.bupt.myvolley.volley;

public class DefaultResultListener implements ResultListener {

	@Override
	public void onError() {
		System.out.println("We can't have a connection with target url.");
	}

	@Override
	public void onResponse(Object o) {
		if(o!=null){
			System.out.println(o);
		}else{
			System.out.println("response object is null.");
		}
	}

}
