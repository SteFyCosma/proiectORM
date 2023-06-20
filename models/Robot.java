package com.example.tpd_server.models;

import com.example.tpd_server.interfaces.RobotInterface;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class Robot implements RobotInterface, Serializable {
    private int id;
    private String name;
    private String description;
    private int year_created;

    public Robot(){

    }
    public Robot(int id, String name, String description, int year_created) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.year_created = year_created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYearCreated() {
        return year_created;
    }

    public void setYearCreated(int year_created) {
        this.year_created = year_created;
    }
}
