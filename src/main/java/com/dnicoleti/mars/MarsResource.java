package com.dnicoleti.mars;

import com.dnicoleti.mars.robot.Robot;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mars")
public class MarsResource {

    @Inject
    private Robot robot;

    @POST
    @Path("{controls: [LRM]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response controlRobot(@PathParam("controls") String controls) {
        robot.receiveControls(controls);
        return Response.ok(robot.getPosition()).build();
    }

}
