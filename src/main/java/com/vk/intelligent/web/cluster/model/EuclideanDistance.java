package com.vk.intelligent.web.cluster.model;

import com.vk.intelligent.web.ontology.DataPoint;


public class EuclideanDistance implements Distance {

    public EuclideanDistance() {
    }

    public double getDistance(DataPoint point1, DataPoint point2) {
        double sum = 0.0;
        double[] p1vals = point1.getAttributeDoubleValues();
        double[] p2vals = point2.getAttributeDoubleValues();
        int size = p1vals.length;
        for(int i = 0; i < size; i++) {
            sum += Math.pow(p1vals[i] - p2vals[i], 2);
        }
        return Math.sqrt(sum);
    }
}
