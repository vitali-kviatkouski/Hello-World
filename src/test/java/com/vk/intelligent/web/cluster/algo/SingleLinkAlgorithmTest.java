package com.vk.intelligent.web.cluster.algo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vk.intelligent.web.ontology.Attribute;
import com.vk.intelligent.web.ontology.Cluster;
import com.vk.intelligent.web.ontology.DataPoint;

public class SingleLinkAlgorithmTest {
    private SingleLinkAlgorithm algo = new SingleLinkAlgorithm();

    @BeforeClass
    public void setUp() {
        algo.addPoint(createDataPoint("Java in Nutshell"));
        algo.addPoint(createDataPoint("Java EE in Nutshell"));
        algo.addPoint(createDataPoint("Ruby in Nutshell"));
        algo.addPoint(createDataPoint("Java Persistence in Action"));
        algo.addPoint(createDataPoint("Ruby Rails 3"));
        algo.addPoint(createDataPoint("Rails for Dummies"));
        algo.addPoint(createDataPoint("Pattern Recognition Practices"));
    }

    private DataPoint createDataPoint(String name) {
        DataPoint dp = new DataPoint(name);
        dp.addAttribute(new Attribute("title", name.split("\\s")));
        return dp;
    }

    @Test
    public void testBuildInitialClusters() {
        List<Cluster> clusters = algo.buildInitialClusters();
        Assert.assertEquals(clusters.size(), algo.getPointsCount());
    }

    @Test
    public void testBuildClusters() {
        for (int i = 0; i <= 10; i++) {
            List<Cluster> clusters = algo.buildClusters(i);
        }
    }
}
