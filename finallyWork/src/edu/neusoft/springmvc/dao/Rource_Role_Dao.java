package edu.neusoft.springmvc.dao;

import java.util.List;

import edu.neusoft.springmvc.model.Rource_Role;

public interface Rource_Role_Dao {
    public List<Rource_Role> selectResource(int roleid);
}
