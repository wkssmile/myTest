package com.keshi.mytest.core.test;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.ss.formula.functions.Count;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.keshi.mytest.core.about.http.SomSiteRequest;

import fun.jerry.httpclient.bean.HttpRequestHeader;

public class TestTrac {

	public static void main(String[] args) {

		String url = "https://www.trackico.io/ico/nucleus/";
		// String url = "https://www.trackico.io/ico/cardano/";
		HttpRequestHeader header = new HttpRequestHeader();
		header.setUrl(url);
		String html = SomSiteRequest.getPageContent(header);
		Document doc = Jsoup.parse(html);
		Elements block_descriptioneles = doc.select("div.card-body > div.row > div.col-12  p");
		if (block_descriptioneles != null && block_descriptioneles.size() > 0) {
			// System.out.println(block_descriptioneles.toString());
			String block_description = block_descriptioneles.text().trim();
			System.out.println("block_description:" + block_description);
		}

		String block_name = "";
		String block_tag = "";
		Elements block_nameles = doc.select("div.flexbox > div.flex-grow > div.align-items-baseline > h1");
		if (block_nameles != null && block_nameles.size() > 0) {
			String temp = block_nameles.text();
			if (temp.contains("(") && temp.contains(")")) {
				block_name = StringUtils.substringBefore(temp, "(").trim();
				block_tag = StringUtils.substringBetween(temp, "(", ")").trim();
			} else {
				block_name = temp.trim();
			}
			System.out.println("block_name:" + block_name);
			System.out.println("block_tag:" + block_tag);
		}

		Elements logo_urleles = doc.select("div.card-body > div.flexbox > div.img-thumbnail > img");
		if (logo_urleles != null && logo_urleles.size() > 0) {
			// System.out.println(logo_urleles.toString());
			String logo_url = logo_urleles.attr("src").trim();
			if (!logo_url.contains("https://www.trackico.io")) {
				logo_url = "https://www.trackico.io" + logo_url;
			}
			System.out.println("logo_url:" + logo_url);
		}

		Elements eles = doc.select("div.card-body > div.flexbox > div.flex-grow > div.d-flex.flex-row.align-items-center.flex-wrap.mt-2 > a");
		if (eles != null && eles.size() > 0) {
			for (Element ele : eles) {
				System.out.println("=============");
				// System.out.println("ele:" + ele.toString());
				// System.out.println("btn-label:" + ele.hasClass("btn-label"));
				// block_lable_name
				String block_lable_name = "";
				// block_lable_url
				String block_lable_url = "";
				if (ele.hasClass("btn-label")) {
					block_lable_name = ele.text().trim();
					block_lable_url = ele.attr("href").trim();
				} else {
					block_lable_name = ele.attr("data-original-title").trim();
					block_lable_url = ele.attr("href").trim();
				}
				if (!block_lable_url.contains("http")) {
					block_lable_url = "http://" + block_lable_url;
				}

				// System.out.println("block_lable_name:" + block_lable_name);
				// System.out.println("block_lable_url:" + block_lable_url);
			}
		}
		//
		Elements teameles = doc.select("div.tab-content > div#tab-team >div.row.equal-height > div");
		if (teameles != null && teameles.size() > 0) {
			Boolean isNotAdvisors = true;
			for (Element ele : teameles) {

				if (isNotAdvisors) {
					// 区分有没有顾问Advisors
					String temp = ele.attr("class");
					if (temp.equals("col-12")) {
						isNotAdvisors = false;
						continue;
					}
					// 解析team
					System.out.println("解析team");
					// System.out.println(ele.toString());
					extraOneMember(ele);
					System.out.println("----team-----" + ele.attr("class"));

				} else {
					// 解析顾问
					System.out.println("解析顾问");
					extraOneMember(ele);
					// System.out.println(ele.toString());
					System.out.println("----顾问-----" + ele.attr("class"));
				}
			}
		}
	}

	public static void extraOneMember(Element ele) {
		// 人员名称member_name
		String member_name = "";
		Elements member_nameles = ele.select("div.card > div.card-body > h5");
		if (member_nameles != null && member_nameles.size() > 0) {
			member_name = member_nameles.text().trim();
		}
		// 人员链接 member_url
		String member_url = "";
		Elements member_urleles = ele.select("div.card > div.card-body > h5 > a");
		if (member_urleles != null && member_urleles.size() > 0) {
			member_url = member_nameles.attr("href");
			if (!member_url.contains("https://www.trackico.io")) {
				member_url = "https://www.trackico.io" + member_url;
			}
		}

		// 人员责任（职位） member_position
		String member_position = "";
		Elements member_positioneles = ele.select("div.card > div.card-body > span");
		if (member_positioneles != null && member_positioneles.size() > 0) {
			member_position = member_positioneles.text().trim();
		}
		// 头像地址 member_photo_url
		String member_photo_url = "";
		Elements member_photo_urleles = ele.select("div.card > div.card-body > a > span.avatar > img");
		if (member_photo_urleles != null && member_photo_urleles.size() > 0) {
			member_photo_url = member_photo_urleles.attr("src");
			if (!member_photo_url.contains("https://www.trackico.io")) {
				member_photo_url = "https://www.trackico.io" + member_photo_url;
			}
		}
		// 人员类型 member_type
		String member_type = "member";
		System.out.println("member_name:" + member_name);
		System.out.println("member_url:" + member_url);
		System.out.println("member_position:" + member_position);
		System.out.println("member_photo_url:" + member_photo_url);
		System.out.println("member_type:" + member_type);

	}

}
