package com.keshi.mytest.core.tools.ReadExcel;

import java.io.File;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Test {
	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\EDDC\\Desktop\\汽车-口碑\\汽车之家-字体-对应 - 副本.xlsx");
			File file1 = new File("C:\\Users\\EDDC\\Desktop\\汽车-口碑\\汽车之家-字体-对应 - 副本-write-test.xlsx");
			Workbook workbook = ExcelHandle.getWorkbook(file);
			Workbook workbook1 = ExcelHandle.getWorkbook(file1);
			Sheet sheet1 = workbook1.createSheet();
			Row row = sheet1.createRow(100);
			
			OutputToExcel.outputtoexcel(workbook);
//			ParseExcel.parse_excel(workbook);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
