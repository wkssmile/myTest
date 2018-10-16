package com.keshi.mytest.core.about.file;

import com.keshi.mytest.core.tools.ReadExcel.ExcelHandle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;

import static com.keshi.mytest.core.about.file.ReadLocalFile.readFilePathGetfile;

/**
 * @Description: 读本地文件的文件内容
 * @Author: keshi
 * @CreateDate: 2018年10月12日 11:06
 * @UpdateUser:
 * @UpdateDate:
 * @UpdateRemark:
 * @Version: 1.0
 */
public class GetLocalFileContent {
    /**
     * @param file
     * @methodName readExcelContent
     * @description 读Excel内容
     * @author keshi
     * @date 2018年10月12日 11:08
     */
    public static void readExcelContent(File file) {
        System.out.println("读取文件:" + file.getAbsolutePath());
        try {
            Workbook workbook = ExcelHandle.getWorkbook(file);
            int sheetCount = workbook.getNumberOfSheets(); // Total number of sheets
            for (int s = 0; s < sheetCount; s++) {
                System.out.println("————————————————————————Start processing sheet" + (s + 1) + "————————————————————————");
                String sheetname = workbook.getSheetName(s);
                System.out.println("Name of sheet" + (s + 1) + ":" + sheetname);
                // Set the subscript of the excel sheet: 0 start
                Sheet sheet = workbook.getSheetAt(s);// The first sheet
                // Total number of rows
                int rowLength = sheet.getLastRowNum() + 1;
                System.out.println("Total number of rows:" + rowLength);
                // Get the first line
                Row rowzero = sheet.getRow(0);
                // Total number of columns
                int colLength = rowzero.getLastCellNum();
                System.out.println("Total number of columns:" + colLength);
                for (int rowNum = 0; rowNum < rowLength; rowNum++) {
                    Row row = sheet.getRow(rowNum);
                    System.out.print("第 " + rowNum + " 行    ");
                    for (int c = 0; c < colLength; c++) {
                        Cell row_cell = row.getCell(c);
                        if (row_cell != null) {
                            System.out.print(row_cell.toString() + "  ");
                        }
                    }
                    System.out.println("");
                }
                System.out.println("————————————————————————sheet" + (s + 1) + " processing ends————————————————————————");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param file
     * @methodName readFileByLine
     * @description 按行读文件
     * @author keshi
     * @date 2018年10月12日 12:04
     */
    public static String readFileByLine(File file) {
        System.out.println("读文件:" + file.getAbsolutePath());
        StringBuffer localStrBulider = new StringBuffer();
        if (file.isFile() && file.exists()) {
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "GBK");
                BufferedReader bufferReader = new BufferedReader(inputStreamReader);
                String lineStr = null;
                try {
                    while ((lineStr = bufferReader.readLine()) != null) {
                        localStrBulider.append(lineStr).append("\n");
                    }
                    bufferReader.close();
                    inputStreamReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    System.out.println("file read error!");
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                System.out.println("file catch unsupported encoding!");
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                System.out.println("file not found!");
                e.printStackTrace();
            }
        } else {
            System.out.println("file is not a file or file is not existing!");
            return null;
        }
        return localStrBulider.toString();
    }

    public static void main(String[] args) {
        //        readExcelContent(file);
        String filePath1 = "E:\\data\\ProjectData\\autohome\\reputation_out_20180802-3\\rout\\01chn1pb9268r3jdss60sg0000.html";
        File file1 = readFilePathGetfile(filePath1);
        String content = readFileByLine(file1);
        System.out.println(content);
    }
}
