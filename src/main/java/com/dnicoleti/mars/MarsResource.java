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

    /**
     * <p>Receives a {@code String} that can contain the chars <b>L</b>, <b>R</b> and <b>M</b> to control
     * a robot in a Mars ground with size 5x5 returning its final coordinate.<br/>
     * The robot starts at coordinate (0,0,N) and can't move out of its ground boundaries.</p>
     *
     * <p><b>L</b> and <b>R</b> make the robot rotate on its axis 90 degrees to left or right, respectively,
     * without moving from its current position.<br/>
     * <b>M</b> makes the robot move one position forward.</p>
     *
     * <p><em>Example:</em> The control string <b>MML</b> will move the robot to coordinate (0,2,W)</p>
     *
     * @param controls the control string
     * @return the robot final coordinate
     */
    @POST
    @Path("{controls: [LRM]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response controlRobot(@PathParam("controls") String controls) {
        robot.receiveControls(controls);
        return Response.ok(robot.getCoordinate()).build();
    }

}
