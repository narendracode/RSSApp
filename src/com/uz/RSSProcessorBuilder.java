package com.uz;

import java.util.ArrayList;
import java.util.List;

public  class RSSProcessorBuilder{
	private  String source = null;
	private  List<Conversion> conversions = new ArrayList<Conversion>();
	private  List<Output> outputs = new ArrayList<Output>();
	
	public RSSProcessorBuilder source(String source){
		this.source = source;
		return this;
	}
	
	public RSSProcessorBuilder exclude(String excludeStr){
		conversions.add(new Exclude(excludeStr));
		return this;
	}
	
	public RSSProcessorBuilder replace(String replace,String replaceWith){
		conversions.add(new Replace(replace,replaceWith));
		return this;
	}
	
	public RSSProcessorBuilder stdout(){
		outputs.add(new StdOutput());
		return this;
	}
	
	public RSSProcessorBuilder fileout(String filePath){
		outputs.add(new FileOutput(filePath));
		return this;
	}
	
	
	public RSSProcessor build(){
		return new RSSProcessor(this);
	}
	
	public String getSource() {
		return source;
	}

	public List<Conversion> getConversions() {
		return conversions;
	}

	public List<Output> getOutputs() {
		return outputs;
	}
	
	
}
