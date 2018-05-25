package com.f1ulove.convertor.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.f1ulove.convertor.vo.ClassProperty;
import com.google.common.collect.Lists;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class JsonConverter {

    public String convert2JavaBean(String jsonStr, String className) throws IOException {
        Map<String, String> map = new HashMap<>();
        jsonStr = dealAnnotation(jsonStr, map);
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
        ClassProperty property = new ClassProperty();
        property.setFields(genFields(entries, map));
        property.setImports(Lists.newArrayList("java.util.List", "com.fasterxml.jackson.annotation.JsonProperty"));
        ArrayList<ClassProperty> innerClasses = Lists.newArrayList();
        final String a = null;
        genInnerClass(entries, false, innerClasses, null, map);
        property.setInnerClasses(innerClasses);
        property.setClassName(className);
        Configuration conf = new Configuration(Configuration.getVersion());
        String path = ClassUtils.getDefaultClassLoader().getResource("templates").getPath();
        try {
            conf.setDirectoryForTemplateLoading(new File(path));
            conf.setDefaultEncoding("UTF-8");
            conf.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Map<String, Object> root = new HashMap<>();
            root.put("class", property);
            Template template = conf.getTemplate("class.ftl");
            StringWriter writer = new StringWriter();
            template.process(root, writer);
            System.out.println(writer.toString());
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    private void genInnerClass(Set<Map.Entry<String, Object>> entries, boolean isInner, List<ClassProperty> list, String className, Map<String, String> map) {
        if (isInner) {
            ClassProperty property = new ClassProperty();
            property.setFields(genFields(entries, map));
            property.setClassName(className);
            if (list.stream().noneMatch(l -> l.getClassName().equals(className)))
                list.add(property);
            System.out.println(className);
        }

        entries.forEach(e -> {
            Object value = e.getValue();
            String key = e.getKey();
            String s = genClassName(key);
            if (value instanceof JSONObject) {
                genInnerClass(((JSONObject) value).entrySet(), true, list, s, map);
            } else if (value instanceof JSONArray) {
                Object o = ((JSONArray) value).get(0);
                if (o instanceof JSONObject)
                    genInnerClass(((JSONObject) o).entrySet(), true, list, s, map);
            }
        });
    }

    private List<ClassProperty.Field> genFields(Set<Map.Entry<String, Object>> entries, Map<String, String> map) {

        return entries.stream().map(e -> {
            ClassProperty.Field field = new ClassProperty.Field();
            String key = e.getKey();
            if (key.equals("price_info"))
                System.out.println("---------------------------------------------------");
            Object value = e.getValue();
            String name = underLine2camel(key);
            String type = getShortTypeName(value);
            String s = "";
            if (value instanceof JSONObject)
                type = genClassName(key);
            else if (value instanceof JSONArray) {
                Object o = ((JSONArray) value).get(0);
                if (o instanceof JSONObject) {
                    type = listType(genClassName(key));
                } else
                    type = listType(getShortTypeName(o));
            } else {
                s = String.valueOf(value) == null ? "" : String.valueOf(value);
            }
            s = s + (map.get(key) == null ? "" : map.get(key));
            field.setAnnation(s);
            field.setType(type);
            field.setName(name);
            field.setOriginalName(key);
            return field;
        }).collect(Collectors.toList());
    }


    private String listType(String className) {
        return "List<" + className + ">";
    }

    private String genClassName(String key) {
        return firstChar2UpCase(underLine2camel(key));
    }

    private String firstChar2UpCase(String source) {
        return source.substring(0, 1).toUpperCase() + source.substring(1, source.length());
    }

    private String getShortTypeName(Object value) {
        String typeName = value.getClass().getTypeName();
        return typeName.substring((typeName.lastIndexOf(".") + 1), typeName.length());
    }

    private String underLine2camel(String source) {
        if (!source.contains("_"))
            return source;
        StringBuilder sb = new StringBuilder();
        char[] chars = source.toCharArray();
        boolean flag = false;
        for (char b : chars) {
            if (b == '_')
                flag = true;
            else if (flag) {
                sb.append(Character.toUpperCase(b));
                flag = false;
            } else
                sb.append(b);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String path = ClassUtils.getDefaultClassLoader().getResource("templates").getPath();
        System.out.println(path);
    }

    public String dealAnnotation(String source, Map<String, String> map) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(source.getBytes())));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            if (line.contains("//")) {
                line = line.trim();
                if (line.contains("\",")) {
                    String[] split = line.split("//");
                    line = split[0].substring(0, split[0].lastIndexOf("\"")) + "," + split[1] + split[0].substring(split[0].lastIndexOf("\""), split[0].length());
                } else {
                    String key = line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\""));
                    String value = line.substring(line.indexOf("//"), line.length());
                    map.put(key, value);
                    if (line.contains("{"))
                        line = line.substring(0, line.lastIndexOf("{") + 1);
                    else
                        line = line.substring(0, line.lastIndexOf("//"));
                }
            }
            sb.append(line);
        }
        return sb.toString();
    }
}

