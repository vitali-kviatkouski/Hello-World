package com.vk.intelligent.web.ontology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataPoint {
    private String name;

    private List<Attribute> attributes = new ArrayList<Attribute>();
    
    public DataPoint(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void addAttribute(Attribute attr) {
        attributes.add(attr);
    }

    //TODO: make cacheable
    public double[] getAttributeDoubleValues() {
        int size = this.attributes.size();
        double[] res = new double[size];
        for (int i = 0; i < size; i++) {
            res[i] = this.attributes.get(i).getDoubleValue();
        }
        return res;
    }

    public String[] getAttributeTermValues() {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < attributes.size(); i++) {
            res.addAll(Arrays.asList(attributes.get(i).getTermValue()));
        }
        return res.toArray(new String[res.size()]);
    }

    @Override
    public String toString() {
        return "DataPoint[name=" + name + ", attributes=" + attributes + "]";
    }
}
