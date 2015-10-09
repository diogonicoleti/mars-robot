package com.dnicoleti.mars.robot;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.dnicoleti.mars.ground.Ground;
import com.dnicoleti.mars.robot.coord.Coordinate;
import com.dnicoleti.mars.robot.coord.Direction;

@RunWith(Parameterized.class)
public class RobotTest {

    private Robot robot;
    private String controls;
    private Coordinate expected;

    public RobotTest(String controls, Coordinate expected) {
        this.controls = controls;
        this.expected = expected;
    }

    @Before
    public void setUp() throws Exception {
        robot = new Robot(new Ground(5,5), new Coordinate());
    }

    @Parameters(name = "{0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"M", new Coordinate(0, 1, Direction.NORTH)},
                {"L", new Coordinate(0, 0, Direction.WEST)},
                {"R", new Coordinate(0, 0, Direction.EAST)},
                {"MML", new Coordinate(0, 2, Direction.WEST)},
                {"MMRMMRMMRMM", new Coordinate(0, 0, Direction.WEST)},
                {"RRMMLMM", new Coordinate(2, 0, Direction.EAST)},
                {"MMMMMMMLL", new Coordinate(0, 4, Direction.SOUTH)},
                {"RMMLMRMLM", new Coordinate(3, 2, Direction.NORTH)},
                {"MRMLMRMLMRMLMR", new Coordinate(3, 4, Direction.EAST)},
                {"RMMMMLMMM", new Coordinate(4, 3, Direction.NORTH)},
                {"MMMRMMRRL", new Coordinate(2, 3, Direction.SOUTH)},
                {"MMMMRMMMRMMRMR", new Coordinate(2, 2, Direction.NORTH)}
        });
    }

    @Test
    public void testReceiveControls() throws Exception {
        robot.receiveControls(controls);
        assertEquals(expected, robot.getCoordinate());
    }
}