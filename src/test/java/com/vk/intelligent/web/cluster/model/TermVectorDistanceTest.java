package com.vk.intelligent.web.cluster.model;

import org.testng.annotations.Test;

import junit.framework.Assert;

import com.vk.intelligent.web.ontology.Attribute;
import com.vk.intelligent.web.ontology.DataPoint;

public class TermVectorDistanceTest {
    @Test
    public void testGetDistance() {
        TermVectorDistance dist = new TermVectorDistance();
        double d = dist.getDistance(createDataPoint("Java in a Nutshell"), createDataPoint("Java EE Tutorial"));
        Assert.assertTrue(d > 0);
        System.out.println(d);
        d = dist.getDistance(createDataPoint("Java in a Nutshell"), createDataPoint("Java EE in a Nutshell"));
        System.out.println(d);
    }
    
    private DataPoint createDataPoint(String name) {
        DataPoint dp = new DataPoint(name);
        dp.addAttribute(new Attribute("title", name.split("\\s")));
        return dp;
    }
}
