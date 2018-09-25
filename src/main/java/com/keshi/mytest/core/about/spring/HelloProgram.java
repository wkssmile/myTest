package com.keshi.mytest.core.about.spring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.keshi.mytest.core.about.spring.helloworld.HelloWorld;
import com.keshi.mytest.core.about.spring.helloworld.HelloWorldService;

public class HelloProgram {

	public static String readFileByLines(String filepath) {
		File file = new File(filepath);
		BufferedReader reader = null;
		StringBuffer strbuff = new StringBuffer();
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				System.out.println("line " + line + ": " + tempString);
				line++;
				strbuff.append(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return strbuff.toString();
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("D:\\earlyDataWorkspace\\mytest\\\\src\\beans.xml");

		// String path = "D:\\earlyDataWorkspace\\mytest\\src\\beans.xml";
		// String content = readFileByLines(path);
		// System.out.println(content);
		HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");

		HelloWorld hw = service.getHelloWord();

		hw.sayHello();
	}
}
