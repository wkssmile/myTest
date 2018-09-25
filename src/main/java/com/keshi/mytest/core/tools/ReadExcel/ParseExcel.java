package com.keshi.mytest.core.tools.ReadExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ParseExcel {
	/**
	 * Read Excel test, compatible with Excel 2003/2007/2010
	 * 
	 */
	public static void parse_excel(Workbook workbook) {
		int sheetCount = workbook.getNumberOfSheets(); // Total number of sheets

		for (int s = 0; s < sheetCount; s++) {
			System.out.println("————————————————————————Start processing sheet" + (s + 1) + "————————————————————————");
			String sheetname = workbook.getSheetName(s);
			System.out.println("Name of sheet" + (s + 1) + ":" + sheetname);
			// Set the subscript of the excel sheet: 0 start
			Sheet sheet = workbook.getSheetAt(s);// The first sheet
			// Set the count to skip the first line of the directory
			int count = 0;
			// Total number of rows
			int rowLength = sheet.getLastRowNum() + 1;
			System.out.println("Total number of rows:" + rowLength);
			// Get the first line
			Row rowzero = sheet.getRow(0);
			// Total number of columns
			int colLength = rowzero.getLastCellNum();
			System.out.println("Total number of columns:" + colLength);
			for (int i = 0; i < rowLength; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < colLength; j++) {
					Cell cell = row.getCell(j);
					if (cell == null || "".equals(cell.toString())) {
						System.out.print("null" + " ");
					} else {
						System.out.print(cell.toString() + " ");
					}
				}
				System.out.println();
			}
			System.out.println("————————————————————————sheet" + (s + 1) + " processing ends————————————————————————");
		}
	}
}
