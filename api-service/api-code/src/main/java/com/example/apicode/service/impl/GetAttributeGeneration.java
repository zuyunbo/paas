package com.example.apicode.service.impl;

import com.example.apicode.service.GetTypeService;
import com.example.apicode.service.TempEnum.Type;

import java.util.HashMap;
import java.util.Map;

public class GetAttributeGeneration implements GetTypeService {

    public final Map<String, Object> map ;


    public GetAttributeGeneration(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public Map<Object,Object> getType() {
return null;
    }

    public void GenerateAttributeMethod(String type,String name,String returnCode,String description){
        map.put(Type.TYPE.toString(), type);
        map.put(Type.NAME.toString(), name);
        map.put(Type.RETURNCODE.toString(), returnCode);
        map.put(Type.DESCURIPTION.toString(), description);

    }

}
