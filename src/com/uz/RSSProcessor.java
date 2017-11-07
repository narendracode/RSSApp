package com.uz;



import java.util.List;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.text.StringEscapeUtils;

public class RSSProcessor {
	private  String source = null;
	private  List<Conversion> conversions = null;
	private  List<Output> outputs = null;
	private String output = null;
	private String input = null;

	
	public RSSProcessor(RSSProcessorBuilder builder){
		this.source = builder.getSource();
		this.conversions = builder.getConversions();
		this.outputs = builder.getOutputs();
	}
	
	public void process(){
		parse();
		convert();
		output();
	}
	
	public void parse(){
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(source);
		
	    int statusCode;
		try {
			statusCode = client.executeMethod(method);
		      if (statusCode != HttpStatus.SC_OK) {
		        System.err.println("Method failed: " + method.getStatusLine());
		      }
		      byte[] responseBody = method.getResponseBody();
		    input =   new StringEscapeUtils().unescapeXml(new String(responseBody));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public void convert(){
		for (Conversion conversion : conversions) {
			if(input!=null)
				input = conversion.execute(input);
		}
	}
	
	public void output(){
		for(Output output : outputs){
			if(input !=null)
				output.execute(input);
		}
	}
	
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public List<Conversion> getConversions() {
		return conversions;
	}
	public void setConversions(List<Conversion> conversions) {
		this.conversions = conversions;
	}
	
	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
}
