package com.uz;

import java.io.File;
import java.io.FileWriter;

public class FileOutput implements Output{
	private String path = null;
	
	public FileOutput(String path) {
		super();
		this.path = path;
	}

	@Override
	public void execute(String outputStr) {
		try{
			FileWriter fw = new FileWriter(new File(path),true);
			fw.write(outputStr);
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}