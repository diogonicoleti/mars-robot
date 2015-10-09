package com.dnicoleti.mars;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dnicoleti.mars.robot.Robot;

@Path("/mars")
public class MarsResource {

    @Inject
    private Robot robot;

    @POST
    @Path("{controls: [LRM]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response controlRobot(@PathParam("controls") String controls) {
        robot.receiveControls(controls);
        return Response.ok(robot.getCoordinate()).build();
    }

}
