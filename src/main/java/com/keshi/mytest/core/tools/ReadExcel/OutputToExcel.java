package com.keshi.mytest.core.tools.ReadExcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class OutputToExcel {
	public static void outputtoexcel(Workbook workbook) {
		OutputStream out = null;
		int sheetCount = workbook.getNumberOfSheets(); // Total number of sheets
		try {
			for (int s = 0; s < sheetCount; s++) {
				System.out.println(
						"————————————————————————Start processing sheet" + (s + 1) + "————————————————————————");
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
				// Determine if the result column already exists, create it without
				if ("Result".equals(rowzero.getCell(colLength - 1).getStringCellValue())) {
					colLength = colLength - 1;
				} else {
					/**
					 * Write a new column to the sheet
					 */
					Cell newcell = rowzero.createCell(colLength);
					newcell.setCellValue("Result");
				}

				/*
				 * for (int i = 0; i < rowLength;i++) { Row row = sheet.getRow(i); for (int j =
				 * 0; j < colLength; j++) { Cell cell = row.getCell(j); if(cell==null ||
				 * "".equals(cell.toString())){ System.out.print("null"+" "); }else{
				 * System.out.print(cell.toString()+" "); } } System.out.println(); }
				 */
				int writeflag = 1;// Line number written
				for (int j = 0; j < (rowLength - 1) / 15; j++) {
					/**
					 * Write results back to sheet
					 */
					Row writerow = sheet.getRow(writeflag);
					Cell writecell = writerow.createCell(colLength);
					writecell.setCellValue("true");
					writeflag += 15;
				}
				// Create file output and prepare output table
				out = new FileOutputStream("C:\\Users\\test.xlsx");
				workbook.write(out);
				System.out.println("Data written successfully");
				System.out.println(
						"————————————————————————sheet" + (s + 1) + " processing ends————————————————————————");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
