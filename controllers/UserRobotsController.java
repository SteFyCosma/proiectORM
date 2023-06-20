package com.example.tpd_server.controllers;

import com.example.tpd_server.models.Robot;
import com.example.tpd_server.models.UserRobots;
import com.example.tpd_server.services.UserRobotsService;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/user-Robots")
public class UserRobotsController {
    private static final UserRobotsService userRobotsService = new UserRobotsService();

    @GET
    @Produces("application/json")
    public List<UserRobots> getAll() {
        return userRobotsService.getAll();
    }

    @GET
    @Produces("application/json")
    @Path("/{userId}")
    public List<Robot> getRobotsForUser(@PathParam("userId") int userId) {
        return userRobotsService.getRobotsForUser(userId);
    }

    @POST
    @Consumes("application/json")
    public void add(String response) {
        userRobotsService.add(response);
    }

    @DELETE
    @Consumes("application/json")
    @Path("/{userId}/{RobotId}")
    public void delete(@PathParam("userId") int userId, @PathParam("RobotId") int RobotId){
        userRobotsService.delete(userId, RobotId);
    }
}
