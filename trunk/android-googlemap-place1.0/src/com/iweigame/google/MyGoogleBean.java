package com.iweigame.google;


public class MyGoogleBean {

	private String name;
	
	private String address;

	private String reference;
	
	
	public String getReference() {
		return reference;
	}


	
	public void setReference(String reference) {
		this.reference = reference;
	}


	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getAddress() {
		return address;
	}

	
	public void setAddress(String address) {
		this.address = address;
	}



	public MyGoogleBean(String name, String address, String reference) {
		super();
		this.name = name;
		this.address = address;
		this.reference = reference;
	}


	
	
	
}
