package com.love320.approxy.manager;

public class IPort {
	
	private String ip = "127.0.0.1";
	private Integer port = 22;
	private Integer proxy = 22;
	
	public IPort(Integer proxy,String ip,Integer port ){
		this.ip= ip;
		this.port =port;
		this.proxy = proxy;
	}
	
	public IPort(String ip,Integer port ){
		this.ip= ip;
		this.port =port;
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getProxy() {
		return proxy;
	}

	public void setProxy(Integer proxy) {
		this.proxy = proxy;
	}
	
	
	
}
