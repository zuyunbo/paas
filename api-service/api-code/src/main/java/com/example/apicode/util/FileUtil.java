package com.example.apicode.util;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.util.StrUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author 2u
 */
@Slf4j
public class FileUtil {


    public static void main(String[] args) {

    }

    public String parsingFileReturnString(){
        FileReader fileReader = new FileReader("/Users/zuyunbo/file/文档.yml");
        return fileReader.readString();
    }


    public Map<Object,Object> parseStringGeneratedAttributes(String str){
        String[] a = str.split("[^a-zA-Z]+");
        List<String> strings = Arrays.asList(a);
        for (String string : strings) {
            if (StrUtil.isNotBlank(string)) {
                System.out.println("输出的字母：" + string);
            }
        }
        return null;
    }

    /**
     * 生成文件
     * @return
     */
    public static File makeFile(){
        String targetPath = "/Users/zuyunbo/file";
        // 模板生成后新文件名
        String fileName = "ntest.yml";
        // 创建文件夹
        boolean mkdirs = new File(targetPath).mkdirs();
        if(mkdirs){
            log.error("already exists  mkdirs {}" ,targetPath+fileName);
            throw new RuntimeException("File ["+fileName+"] already exists");
        }
        File nFile = new File(targetPath +"/"+ fileName);
        if (nFile.exists()) {
            log.error("already exists {}" ,targetPath+fileName);
            throw new RuntimeException("File ["+fileName+"] already exists");
        }
        return nFile;
    }

    public static void writerFile( Map<Object, Object> map)  {
        // 模板目录
        String templateDirectory = "/Users/zuyunbo/project/paas/api-service/api-code/src/main/resources/template";
        // 模板名称
        String templateFile = "code.yml";
        // 生成目标文件
        Writer writer ;
        try {
            writer = new FileWriter(makeFile());

            Template template = getConfiguration(templateDirectory).getTemplate(templateFile, "UTF-8");
            template.process(map, writer);
            writer.close();
        } catch (Exception e) {
            log.error("exception {} " ,e.getMessage());
            throw new RuntimeException(e);
        }
    }


    private static Configuration getConfiguration(String templateDirectory) {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);
        try {
            configuration.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
            configuration.setDirectoryForTemplateLoading(new File(templateDirectory));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return configuration;
    }



}
