package com.example.apicode.abstractService.impl;

import com.example.apicode.abstractService.GenerateAttributeType;
import com.example.apicode.service.GetTypeService;
import com.example.apicode.util.FileUtil;

import java.util.Map;

/**
 * @author zuyunbo
 * 生成实体字段属性
 *
 */
public abstract class GenerateEntityAttributes extends GenerateAttributeType {
    public GenerateEntityAttributes(GetTypeService getTypeService) {
        super(getTypeService);
    }

    public void generateCode(){
        Map<Object, Object> type = getTypeService.getType();
        FileUtil.writerFile(type);
    }


}
