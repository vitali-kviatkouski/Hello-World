package com.vk.intelligent.web.cluster.model;

import com.vk.intelligent.web.ontology.DataPoint;


public interface Distance {
    double getDistance(DataPoint point1, DataPoint point2);
}
