package com.qa.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class TestProperites {
    public static Properties loginprop() throws IOException {
        Properties p = new Properties();
        File file = new File("src\\test\\java\\com\\qa\\Utils\\Login.properties");
        FileInputStream ip = new FileInputStream(file.getAbsolutePath());
        p.load(ip);
        return p;
    }
    public static String FilePath(String FileName){
        File file = new File("src\\test\\Templates\\"+FileName);
        String FilePath = file.getAbsolutePath();
        return FilePath;
    }

    public static String DownloadFilePath(String FileName){
        File file = new File("src\\test\\resources\\DownloadDirectory\\"+FileName);
        String FilePath = file.getAbsolutePath();
        return FilePath;
    }
    public static void DeleteExistingFunction(String ExportPath, String FileName){
        try{
            System.out.println("Path "+ExportPath + FileName);
            Files.delete(Paths.get(ExportPath+ FileName));
        } catch (IOException e){
            System.out.println("failed to get file");
        }
    }
}
