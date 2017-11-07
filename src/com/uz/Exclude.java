package com.uz;

public class Exclude implements Conversion{

	private String excludeStr = null;
	
	public Exclude(String excludeStr){
		this.excludeStr = excludeStr;
	}
	
	@Override
	public String execute(String input) {
		return input.replaceAll("(?i)"+excludeStr," "); //matches for all cases
	}

}
