package com.vk.intelligent.web.cluster.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import com.vk.intelligent.web.ontology.DataPoint;

public class TermVectorDistance implements Distance {

    public double getDistance(DataPoint point1, DataPoint point2) {
        String[] p1vals = point1.getAttributeTermValues();
        String[] p2vals = point2.getAttributeTermValues();
        Set<String> set1 = new HashSet<String>();
        set1.addAll(Arrays.asList(p1vals));
        Set<String> set2 = new HashSet<String>();
        set2.addAll(Arrays.asList(p2vals));
        double intSize = CollectionUtils.intersection(set1, set2).size();
        double unionSize = CollectionUtils.union(set1, set2).size();
        double rel = intSize / unionSize;
        return rel == 0 ? 100 : 1.0 / rel;
    }

}
