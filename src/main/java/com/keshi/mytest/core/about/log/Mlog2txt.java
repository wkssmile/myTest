package com.keshi.mytest.core.about.log;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Mlog2txt {

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		String date1 = df.format(date);
		System.out.println(df.format(date));
		try {
			PrintStream mytxt = new PrintStream("./log/" + Mlog2txt.class.getSimpleName() + "-" + date1 + ".log.txt");
			PrintStream out = System.out;
			System.setOut(mytxt);
			System.out.println("文档执行的日期是：" + new Date());
			for (int i = 0; i < 100; i++) {
				System.out.println(date1);
			}
			System.setOut(out);
			System.out.println("日期保存完毕。");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
