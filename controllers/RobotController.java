package com.example.tpd_server.controllers;

import com.example.tpd_server.models.Robot;
import com.example.tpd_server.services.RobotService;
import jakarta.ws.rs.*;

import java.util.ArrayList;

@Path("/Robots")
public class RobotController {
    private static final RobotService RobotsService = new RobotService();

    @GET
    @Produces("application/json")
    public ArrayList<Robot> getAll() {
        return RobotsService.getAll();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Robot get(@PathParam("id") int id) {
        return RobotsService.get(id);
    }

    @POST
    @Consumes("application/json")
    public void add(String response) {
        RobotsService.add(response);
    }

    @DELETE
    @Consumes("application/json")
    @Path("/{RobotId}")
    public void delete(@PathParam("RobotId") int RobotId){
        RobotsService.delete(RobotId);
    }
}
