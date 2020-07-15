package lut.day17.homework;

import java.io.File;

public class DeleteDir {
    public static void main(String[] args) {
        String s = "";
        File file = new File("C:\\Users\\qsg\\Desktop\\tt\\java\\lang");
        DelDir(file);

    }
    public static void DelDir(File file){
        if(file.isDirectory()){
        File[] files = file.listFiles();
        if(files!=null){
            for (File file1 : files) {
                DelDir(file1);
            }
        }
        file.delete();
        }
        if(file.isFile())
            file.delete();


    }
}
