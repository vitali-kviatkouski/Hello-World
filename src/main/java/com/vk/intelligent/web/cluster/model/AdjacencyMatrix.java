package com.vk.intelligent.web.cluster.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.vk.intelligent.web.ontology.DataPoint;

public class AdjacencyMatrix {
    private Distance distance = new EuclideanDistance();

    private boolean actual;
    
    private double[][] matrix;
    
    private List<DataPoint> points = new ArrayList<DataPoint>();
    
    public AdjacencyMatrix() {
    }
    
    public AdjacencyMatrix(DataPoint... points) {
        for (DataPoint point : points) {
            this.points.add(point);
        }
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public AdjacencyMatrix(List<DataPoint> points) {
        this.points.addAll(points);
    }

    public void addPoint(DataPoint point) {
        this.points.add(point);
        actual = false;
    }

    public double[][] getMatrix() {
        if (!actual) {
            buildMatrix();
        }
        return matrix;
    }

    private void buildMatrix() {
        int size = points.size();
        matrix = new double[size][size];
        // TODO: optimize by building triangle matrix
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 0;
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    matrix[i][j] = distance.getDistance(points.get(i), points.get(j));
                }
            }
        }
    }

    @Override
    public String toString() {
        if (!actual) {
            buildMatrix();
        }
        DecimalFormat format = new DecimalFormat("##.##");
        int size = matrix.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("\n");
            }
            for (int j = 0; j < size; j++) {
                sb.append(format.format(matrix[i][j])).append("\t");
            }
        }
        return sb.toString();
    }
}
