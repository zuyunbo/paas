package com.service.concurrency.design.brideg;

import java.io.FileInputStream;
import java.io.IOException;

public class TestFileInputStreamDemo {

    public static void main(String[] args) {
        TestFileInputStreamDemo testFileInputStream = new TestFileInputStreamDemo();
        String path = "/Users/zuyunbo/file/测试1-1-1-2.txt";
        testFileInputStream.readFileByFileInputStream(path);
    }

    public void readFileByFileInputStream(String path) {
        FileInputStream fileInputStream = null;
        try {
            // 创建文件输入流对象
            fileInputStream = new FileInputStream(path);
            // 设定读取的字节数
            int n = 1024;
            byte buffer[] = new byte[1024];
            // 读取输入流
            System.out.println("readFileByFileInputStream执行结果：");
            while ((fileInputStream.read(buffer, 0, n) != -1) && (n > 0)) {
                System.out.print(new String(buffer));
            }
            System.out.println();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭输入流
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
