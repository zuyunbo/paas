package com.service.concurrency.design.brideg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Demo {


    public static void main(String[] args) throws Exception {
        Demo demo = new Demo();
        String path = "/Users/zuyunbo/file/测试1-1-1-1.txt";
        demo.readFileByFileReader(path);
        demo.readFileByBufferedReader(path);
    }


    public void readFileByFileReader(String path) throws Exception {

        FileReader fileReader = null;

        fileReader = new FileReader(path);

        char[] buf = new char[1024];

        int temp = 0;
        System.out.println("readFileByFileReader执行结果");

        while ((temp = fileReader.read(buf)) != -1) {
            System.out.print(new String(buf, 0, temp));
            System.out.println();
        }

        fileReader.close();
    }

    public void readFileByBufferedReader(String path) throws Exception {
        File file = new File(path);
        if (file.isFile()) {
            BufferedReader bufferedReader = null;
            FileReader fileReader = null;
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            System.out.println("readFileByBufferReader执行结果：");
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
            fileReader.close();
            bufferedReader.close();
        }

    }
}
