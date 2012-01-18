package com.vk.intelligent.web.ontology;

public class Attribute {
    private String name;
    private Object value;

    public Attribute(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public Attribute(String name, String[] value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getDoubleValue() {
        return (Double) value;
    }

    public String[] getTermValue() {
        return (String[]) value;
    }

    @Override
    public String toString() {
        return "Attr[name=" + name + ", value=" + value + "]";
    }
}
