package com.keshi.mytest.core.about.log4j;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class Log4jTest2 {
	static String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	static String logFilePath = "log/" + Log4jTest2.class.getSimpleName() + "-" + date + "-log.txt";

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Log4jTest2.class);
		SimpleLayout layout = new SimpleLayout();
		// HTMLLayout layout = new HTMLLayout();
		FileAppender appender = null;
		try {
			// 把输出端配置到out.txt
			appender = new FileAppender(layout, logFilePath, false);
			
		} catch (Exception e) {
		}
		logger.addAppender(appender);// 添加输出端
		logger.setLevel((Level) Level.DEBUG);// 覆盖配置文件中的级别
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");
		for (int i = 0; i < 100; i++) {
			logger.info(i);
		}
	}

}
