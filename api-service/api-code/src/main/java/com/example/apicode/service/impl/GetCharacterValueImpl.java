package com.example.apicode.service.impl;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.util.StrUtil;
import com.example.apicode.service.GetTypeService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * @author zuyunbo
 */
public class GetCharacterValueImpl  implements GetTypeService {



    @Override
    public Map<Object,Object> getType() {
        //默认UTF-8编码，可以在构造中传入第二个参数做为编码
        FileReader fileReader = new FileReader("/Users/zuyunbo/file/文档.yml");
        String result = fileReader.readString();
        System.out.println(result);
        return null;
    }


    public static void main(String[] args) {
        FileReader fileReader = new FileReader("/Users/zuyunbo/file/文档.yml");
        String result = fileReader.readString();
        String[] a = result.split("[^a-zA-Z]+");
        List<String> strings = Arrays.asList(a);
        for (String string : strings) {
            if (StrUtil.isNotBlank(string)) {
                System.out.println("输出的字母：" + string);
            }
        }
        System.out.println(result);
    }
}
