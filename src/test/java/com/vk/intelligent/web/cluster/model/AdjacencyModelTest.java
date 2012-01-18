package com.vk.intelligent.web.cluster.model;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vk.intelligent.web.ontology.Attribute;
import com.vk.intelligent.web.ontology.DataPoint;

public class AdjacencyModelTest {
    private AdjacencyMatrix matrix = new AdjacencyMatrix();

    @BeforeClass
    public void setUp() {
        matrix.addPoint(createPoint(1, 0, 1));
        matrix.addPoint(createPoint(2, 1, 1));
        matrix.addPoint(createPoint(3, 1, 2));
        matrix.addPoint(createPoint(4, 2, 3));
        matrix.addPoint(createPoint(5, 3, 3));
        matrix.addPoint(createPoint(6, 2, 5));
        matrix.addPoint(createPoint(7, 4, 5));
        matrix.addPoint(createPoint(8, 4, 0));
    }

    private DataPoint createPoint(int num, int x, int y) {
        DataPoint point = new DataPoint(String.valueOf(num));
        point.addAttribute(new Attribute("X", x));
        point.addAttribute(new Attribute("Y", y));
        return point;
    }

    @Test
    public void testGetMatrix() {
        double[][] matrix = this.matrix.getMatrix();
        Assert.assertNotNull(matrix);
        System.out.println(this.matrix.toString());
    }
}
