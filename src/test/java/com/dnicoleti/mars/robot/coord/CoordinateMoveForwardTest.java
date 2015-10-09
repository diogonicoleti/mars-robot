package com.dnicoleti.mars.robot.coord;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.dnicoleti.mars.ground.Ground;

@RunWith(Parameterized.class)
public class CoordinateMoveForwardTest {

    private Coordinate coordinate;
    private Coordinate expected;

    public CoordinateMoveForwardTest(Coordinate coordinate, Coordinate expected) {
        this.coordinate = coordinate;
        this.expected = expected;
    }

    @Parameters
    public static Iterable<Coordinate[]> data() {
        return Arrays.asList(new Coordinate[][]{
                {new Coordinate(0, 0, Direction.NORTH), new Coordinate(0, 1, Direction.NORTH)},
                {new Coordinate(0, 0, Direction.SOUTH), new Coordinate(0, 0, Direction.SOUTH)},
                {new Coordinate(0, 0, Direction.EAST), new Coordinate(1, 0, Direction.EAST)},
                {new Coordinate(0, 0, Direction.WEST), new Coordinate(0, 0, Direction.WEST)},
                {new Coordinate(3, 3, Direction.NORTH), new Coordinate(3, 4, Direction.NORTH)},
                {new Coordinate(3, 3, Direction.SOUTH), new Coordinate(3, 2, Direction.SOUTH)},
                {new Coordinate(3, 3, Direction.EAST), new Coordinate(4, 3, Direction.EAST)},
                {new Coordinate(3, 3, Direction.WEST), new Coordinate(2, 3, Direction.WEST)},
                {new Coordinate(5, 5, Direction.NORTH), new Coordinate(5, 5, Direction.NORTH)},
                {new Coordinate(5, 5, Direction.SOUTH), new Coordinate(5, 4, Direction.SOUTH)},
                {new Coordinate(5, 5, Direction.EAST), new Coordinate(5, 5, Direction.EAST)},
                {new Coordinate(5, 5, Direction.WEST), new Coordinate(4, 5, Direction.WEST)}
        });
    }

    @Test
    public void testMoveForward() throws Exception {
        coordinate.moveForward(new Ground(5,5));
        assertEquals(expected, coordinate);
    }

}