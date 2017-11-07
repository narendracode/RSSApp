package com.uz;

public class StdOutput implements Output{
	
	@Override
	public void execute(String outputStr) {
		System.out.println(outputStr);
	}
}
