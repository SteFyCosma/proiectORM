package com.example.tpd_server.interfaces;

import javax.ejb.Remote;

@Remote
public interface GoogleRobotsInterface {
	
    int getId();
    void setId(int id);
	
    String getName();
    void setName(String name);
	
    String getDescription();
    void setDescription(String description);
	
    int getYearCreated();
    void setYearCreated(int year_created);
	
}
