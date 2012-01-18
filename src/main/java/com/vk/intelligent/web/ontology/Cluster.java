package com.vk.intelligent.web.ontology;

import java.util.ArrayList;
import java.util.List;

public class Cluster {
    private String name;
    private List<DataPoint> points = new ArrayList<DataPoint>();

    public Cluster(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<DataPoint> getPoints() {
        return points;
    }

    public void addPoint(DataPoint point) {
        points.add(point);
    }

    public void addPoints(List<DataPoint> points) {
        this.points.addAll(points);
    }

    public boolean containsPoint(String name) {
        for (DataPoint point : points) {
            if (name.equals(point.getName())) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        String str = "Cluster [name=" + name + ", points=";
        for (DataPoint point : points) {
            str += point.getName() + ",";
        }
        return str + "]";
    }
}
