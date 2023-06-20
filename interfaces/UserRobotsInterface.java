package com.example.tpd_server.interfaces;

import javax.ejb.Remote;

@Remote
public interface UserRobotsInterface {
	
    int getUserId();
    void setUserId(int userId);
	
    int getRobotId();
    void setRobotId(int robotId);
	
}
