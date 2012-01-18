package com.vk.intelligent.web.cluster.algo;

import java.util.ArrayList;
import java.util.List;

import com.vk.intelligent.web.cluster.model.AdjacencyMatrix;
import com.vk.intelligent.web.cluster.model.TermVectorDistance;
import com.vk.intelligent.web.ontology.Cluster;
import com.vk.intelligent.web.ontology.DataPoint;

public class SingleLinkAlgorithm {
    private List<DataPoint> points = new ArrayList<DataPoint>();
    
    public void addPoint(DataPoint point) {
        points.add(point);
    }

    public int getPointsCount() {
        return points.size();
    }

    public List<Cluster> buildInitialClusters() {
        List<Cluster> clusters = new ArrayList<Cluster>();
        for (int i = 0; i < points.size(); i++) {
            clusters.add(new Cluster("Cluster-" + String.valueOf(i)));
        }
        return clusters;
    }
    
    public List<Cluster> buildClusters(int distance) {
        List<Cluster> clusters = new ArrayList<Cluster>();
        AdjacencyMatrix mtx = new AdjacencyMatrix(points);
        mtx.setDistance(new TermVectorDistance());
        int size = points.size();
        boolean[] usedPoints = new boolean[size];
        double[][] matrix = mtx.getMatrix();
        System.out.println(mtx);
        // TODO: calculate triangle matrix
        for (int i = 0; i < size; i++) {
            if (usedPoints[i]) continue;
            List<DataPoint> clPoints = new ArrayList<DataPoint>();
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] <= distance && !usedPoints[j]) {
                    clPoints.add(points.get(j));
                    usedPoints[j] = true;
                }
            }
            if (clPoints.size() > 0) {
                Cluster cluster = new Cluster("Cluster-" + String.valueOf(clusters.size()));
                cluster.addPoints(clPoints);
                clusters.add(cluster);
            }
        }
        for (Cluster cluster : clusters) {
            System.out.println(cluster);
        }
        return clusters;
    }
}
