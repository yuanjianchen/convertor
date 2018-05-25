package com.f1ulove.convertor.vo;

import java.util.List;

public class ClassProperty {
    private String className;
    private List<String> imports;
    private List<Field> fields;
    private List<ClassProperty> innerClasses;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<String> getImports() {
        return imports;
    }

    public void setImports(List<String> imports) {
        this.imports = imports;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public List<ClassProperty> getInnerClasses() {
        return innerClasses;
    }

    public void setInnerClasses(List<ClassProperty> innerClasses) {
        this.innerClasses = innerClasses;
    }


    public static class Field {
        private String name;
        private String type;
        private String originalName;
        private String annation;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOriginalName() {
            return originalName;
        }

        public void setOriginalName(String originalName) {
            this.originalName = originalName;
        }

        public String getAnnation() {
            return annation;
        }

        public void setAnnation(String annation) {
            this.annation = annation;
        }

        @Override
        public String toString() {
            return "Field{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", originalName='" + originalName + '\'' +
                    ", annation='" + annation + '\'' +
                    '}';
        }
    }
}
