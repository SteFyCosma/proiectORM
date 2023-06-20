package com.example.tpd_server.models;

import com.example.tpd_server.interfaces.UserRobotsInterface;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class UserRobots implements UserRobotsInterface, Serializable {
    private int userId;
    private int robotId;

    public UserRobots(){

    }
    public UserRobots(int userId, int robotId) {
        this.userId = userId;
        this.robotId = robotId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRobotId() {
        return robotId;
    }

    public void setRobotId(int robotId) {
        this.robotId = robotId;
    }
}
