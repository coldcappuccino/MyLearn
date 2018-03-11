package edu.neusoft.springmvc.dao;

import edu.neusoft.springmvc.model.resource;

public interface ResourceDao {
    public resource find(int sourceID);
}
