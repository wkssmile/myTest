package com.keshi.mytest.core.about.http;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import fun.jerry.common.LogSupport;
import fun.jerry.httpclient.bean.HttpRequestHeader;

public class HttpTest {

	private static final Logger log = LogSupport.getHttplog();

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			String url = "http://www.ellechina.com/";
			HttpRequestHeader header = new HttpRequestHeader();
			header.setUrl(url);
			String html = SomSiteRequest.getPageContent(header);
			Document doc = Jsoup.parse(html);
			String title = doc.title();
			log.info("title:" + title);
			// System.out.println(html);
		}
	}
}
