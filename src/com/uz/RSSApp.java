package com.uz;

public class RSSApp {

	public static void main(String[] args) {
		RSSProcessor rssProcessor = new RSSProcessorBuilder()
											 .source("http://tech.uzabase.com/rss")
											 .exclude("NewsPicks")
											 .stdout()
											 .fileout("/Users/nsoni/Desktop/output.txt")
											 .build();
		rssProcessor.process();

	}

}
