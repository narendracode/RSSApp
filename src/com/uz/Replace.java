package com.uz;

public class Replace implements Conversion{
	private String replace;
	private String replaceWith;

	public Replace(String replace, String replaceWith){
		this.replace = replace;
		this.replaceWith = replaceWith;
	}
	
	
	@Override
	public String execute(String input) {
		return input.replaceAll(replace,replaceWith);

	}

}
