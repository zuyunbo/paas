package com.cloud.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Map<String, Object> hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        return map;
    }


}
