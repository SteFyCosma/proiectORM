package com.example.tpd_server.services;

import com.example.tpd_server.data_access.RobotDAO;
import com.example.tpd_server.models.Robot;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class RobotService {
    public ArrayList<Robot> getAll() {
        return RobotDAO.getAll();
    }

    public Robot get(int id) {
        if (id < 0) {
            return null;
        }
        return RobotDAO.get(id);
    }

    public void add(String response) {
        if (response.isEmpty()) {
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            Robot robot = mapper.readValue(response, new TypeReference<>() {
            });
            RobotDAO.add(robot);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int robotId) {
        if (robotId < 0) {
            return;
        }

        try {
            RobotDAO.delete(robotId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
