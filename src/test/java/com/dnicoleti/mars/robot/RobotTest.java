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
                {"M", new Coordinate(Direction.NORTH, 0, 1)},
                {"L", new Coordinate(Direction.WEST, 0, 0)},
                {"R", new Coordinate(Direction.EAST, 0, 0)},
                {"MML", new Coordinate(Direction.WEST, 0, 2)},
                {"MMRMMRMMRMM", new Coordinate(Direction.WEST, 0, 0)},
                {"RRMMLMM", new Coordinate(Direction.EAST, 2, 0)},
                {"MMMMMMMLL", new Coordinate(Direction.SOUTH, 0, 4)},
                {"RMMLMRMLM", new Coordinate(Direction.NORTH, 3, 2)},
                {"MRMLMRMLMRMLMR", new Coordinate(Direction.EAST, 3, 4)},
                {"RMMMMLMMM", new Coordinate(Direction.NORTH, 4, 3)},
                {"MMMRMMRRL", new Coordinate(Direction.SOUTH, 2, 3)},
                {"MMMMRMMMRMMRMR", new Coordinate(Direction.NORTH, 2, 2)}
        });
    }

    @Test
    public void testReceiveControls() throws Exception {
        robot.receiveControls(controls);
        assertEquals(expected, robot.getCoordinate());
    }
}