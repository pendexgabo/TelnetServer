package com.sosagabriel.telnet.server;

public class Response {
	private String response = null;
	private boolean keepalive = true;
	
	public boolean keepalive() {
		return keepalive;
	}

	public void keepalive(boolean keepalive) {
		this.keepalive = keepalive;
	}

	public Response(String string, boolean keepalive) {
		this.response = string;
		this.keepalive = keepalive;
	}
	
	public Response(String string) {
		this.response = string;
	}

	public Response() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return response;
	}
	
	public void set(String response) {
		this.response = response;
	}
	
	

}
