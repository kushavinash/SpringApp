package com.avi.utils;

public class NoDataFoundException extends Exception {
	
	int id;
	String erroDescription;
	
	  public  NoDataFoundException (String msg){		  
		  
		  super(msg);
		  
	  }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getErroDescription() {
		return erroDescription;
	}

	public void setErroDescription(String erroDescription) {
		this.erroDescription = erroDescription;
	}
	

}
