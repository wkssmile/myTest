package com.keshi.mytest.core.about.file;

import java.io.File;
import java.util.ArrayList;

/**
 * @Description: 读本地文件
 * @Author: keshi
 * @CreateDate: 2018年10月12日 10:42
 * @UpdateUser:
 * @UpdateDate:
 * @UpdateRemark:
 * @Version: 1.0
 */

public class ReadLocalFile {

    /**
     * @param fileDirPath
     * @methodName readFileGetPath
     * @description 读文件夹下的所有文件，返回文件路径
     * @author keshi
     * @date 2018年10月11日 12:57
     */
    public static ArrayList<String> readFileGetPath(String fileDirPath) {
        ArrayList<String> filePathList = new ArrayList<String>();
        File fileDir = new File(fileDirPath);
        //文件存在
        if (fileDir.exists()) {
            //文件是文件夹
            if (fileDir.isDirectory()) {
                File files[] = fileDir.listFiles();
                for (int i = 0; i < files.length; i++) {
                    File file = files[i];
                    String filepath = file.getAbsolutePath();
//                    System.out.println(filepath);
                    filePathList.add(filepath);
                }
            }
        }
        return filePathList;
    }

    /**
     * @param fileDirPath
     * @methodName readFileDirPathGetFiles
     * @description 读取文件夹下的的所有文件，返回文件列表
     * @author keshi
     * @date 2018年10月12日 10:54
     */
    public static ArrayList<File> readFileDirPathGetFiles(String fileDirPath) {
        ArrayList<File> fileList = new ArrayList<File>();
        try {
            File fileDir = new File(fileDirPath);
            //文件夹是否存在
            if (fileDir.exists()) {
                //是否是文件夹
                if (fileDir.isDirectory()) {
                    File files[] = fileDir.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        File file = files[i];
                        fileList.add(file);
                    }
                } else {
                    System.out.println("erro,路径不是文件夹:" + fileDirPath);
                }
            } else {
                System.out.println("erro,路径不存在:" + fileDirPath);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileList;
    }

    /**
     * @param filePath
     * @methodName readFilePathGetfile
     * @description 读取本地的一个文件路径，返回文件
     * @author keshi
     * @date 2018年10月12日 11:12
     */
    public static File readFilePathGetfile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.exists()) {
                if (!file.isDirectory()) {
                    return file;
                } else {
                    System.out.println("erro,改路径是文件夹:" + filePath);
                }
            } else {
                System.out.println("erro,路径不存在:" + filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String fileDir = "E:\\data\\ProjectData\\linkedin\\linkedin处理";
//        ArrayList<File> fileList = readFileDirPathGetFiles(fileDir);
//        for (File file : fileList) {
//            System.out.println(file.getAbsolutePath());
//        }
        String filePath = "E:\\data\\ProjectData\\linkedin\\linkedin处理\\for_check_2.xlsx";
        File file = readFilePathGetfile(fileDir);
        System.out.println(file.getAbsolutePath());

    }
}
