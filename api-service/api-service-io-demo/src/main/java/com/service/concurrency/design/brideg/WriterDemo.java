package com.service.concurrency.design.brideg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo {
    public static void main(String[] args) throws IOException {
        WriterDemo testWriter = new WriterDemo();
        String path = "/Users/zuyunbo/file/文档.yml";
        testWriter.writeFileByFileWriter(path);
        testWriter.writeFileByBufferWriter(path);
    }


    public void writeFileByFileWriter(String path) throws IOException {
        FileWriter fileWriter = null;
        fileWriter = new FileWriter(path, true);
        fileWriter.write("这是一个游戏数据\r\n");
        fileWriter.flush();
        fileWriter.close();
    }

    public void writeFileByBufferWriter(String path) throws IOException {
        File file = new File(path);
        if (file.isFile()) {
            BufferedWriter bufferedWriter = null;
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("本行是通过bufferedWriter加入的行\r\n");
            bufferedWriter.flush();
            fileWriter.close();
            bufferedWriter.close();
        }
    }
}
