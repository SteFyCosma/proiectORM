package com.example.tpd_server.services;

import com.example.tpd_server.data_access.UserRobotsDAO;
import com.example.tpd_server.models.Robot;
import com.example.tpd_server.models.UserRobots;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class UserRobotsService {
    public ArrayList<UserRobots> getAll() {
        return UserRobotsDAO.getAll();
    }

    public List<Robot> getRobotsForUser(int id) {
        if(id < 0){
            return null;
        }
        return UserRobotsDAO.getRobotsForUser(id);
    }

    public void add(String response) {
        if (response.isEmpty()) {
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            UserRobots userMotorcycle = mapper.readValue(response, new TypeReference<>() {
            });
            UserRobotsDAO.add(userMotorcycle);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int userId, int robotId) {
        if (userId < 0 || robotId < 0) {
            return;
        }

        try {
            UserRobotsDAO.delete(userId, robotId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
