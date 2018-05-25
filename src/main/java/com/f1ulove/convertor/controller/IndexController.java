package com.f1ulove.convertor.controller;

import com.f1ulove.convertor.json.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class IndexController {

    @Autowired
    JsonConverter convertor;

    @RequestMapping(value = {"", "/"})
    public String index() {
        return "index";
    }

    @RequestMapping("convert/javaBean")
    @ResponseBody
    public String convert2JavaBean(@RequestParam String jsonStr, @RequestParam(required = false) String className) throws IOException {
        className = className == null || className.trim().equals("") ? "GenClass" : className;
        return convertor.convert2JavaBean(jsonStr, className);
//        try {
//            convertor.dealAnnotation(jsonStr);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "";
    }
}
