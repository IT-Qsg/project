package lut.day17.homework;

import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        File file = new File(s);
       /* String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
        String[] s = file.list((f1, n1) -> {
            return n1.contains("照");
        });
        for (String s1 : s) {
            System.out.println("----------"+s1);
        }*/
        FindJavaFile(file);
    }
    public static void FindJavaFile(File file){
        boolean directory = file.isDirectory();
        if(directory){
            File[] files = file.listFiles();
            if(files!=null){
                for (File file1 : files) {
                    FindJavaFile(file1);
                }
            }
        }
        boolean file1 = file.isFile();
        if(file1){
            String name = file.getName();
            if(name.endsWith(".java")){
                System.out.println(file);
            }
        }
    }
}
