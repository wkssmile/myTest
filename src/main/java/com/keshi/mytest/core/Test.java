package com.keshi.mytest.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

public class Test {
	public static void main(String[] args) throws ParseException {
		// 获取开始时间
		long startTime = System.currentTimeMillis();

		for (int i = 2;; i++) {
			System.out.println(i);
			if (i == 100) {
				break;
			}
		}
		try {
			Thread.sleep(65340);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// 获取结束时间
		long endTime = System.currentTimeMillis();

		long mss = endTime - startTime;
		String timestr = formatDuring(mss);
		System.out.println(timestr);
	}

	public static String formatDuring(long mss) {
		long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
		long seconds = (mss % (1000 * 60)) / 1000;
		return hours + " 小时 " + minutes + " 分钟 " + seconds + " 秒 ";
	}

	public double getStarValue(String starWidth) {
		double starValue = 0;
		if (starWidth.contains("width:") && starWidth.contains("%")) {
			String starstr = StringUtils.substringBetween(starWidth, "width:", "%");
			double width = Double.valueOf(starstr);
			System.out.println(width);
			starValue = width / 20;
		}
		return starValue;
	}
}
