package com.keshi.mytest.core.about.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
* @ClassName: File2local 
* @Description: 保存文件到本地路径，按日期创建文件夹
* @author keshi
* @date 2018年8月29日 下午1:12:38 
*  
*/
public class File2local {

	private static String outputFilePath;

	/**
	 * 将指定信息保存到本地
	 * @param dir
	 * @param content
	 * @throws IOException 
	 */
	public static void saveData(String dir, String content) throws IOException {
		FileOutputStream outputStream = null;
		OutputStreamWriter osw = null;
		try {
			outputStream = new FileOutputStream(dir);
			osw = new OutputStreamWriter(outputStream, "GBK");
			osw.write(content);
			osw.flush();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		} catch (IOException e) {
			throw new IOException();
		} finally {
			try {
				osw.close();
				outputStream.close();
			} catch (IOException e) {
			}
		}

	}

	public static void main(String[] args) {
		String html = "abcd";
		// 获得当前时间 创建文件夹
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = df.format(new Date());
		String filePath = "autoHomeReputationDetailHtml-" + date;
		System.out.println(filePath);
		File autohomedir = new File("autoHomeReputationHtml");
		if (!autohomedir.exists()) {
			autohomedir.mkdirs();
		}
		File onetimesdir = new File("autohomeReputationHtml/" + filePath);
		if (!onetimesdir.exists()) {
			onetimesdir.mkdirs();
		}
		outputFilePath = onetimesdir.getPath() + "/";
		System.out.println(outputFilePath);
		try {
			saveData(outputFilePath + "a.html", html);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
