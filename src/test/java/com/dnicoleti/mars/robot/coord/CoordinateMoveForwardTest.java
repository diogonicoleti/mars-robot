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
                {new Coordinate(Direction.NORTH, 0, 0), new Coordinate(Direction.NORTH, 0, 1)},
                {new Coordinate(Direction.SOUTH, 0, 0), new Coordinate(Direction.SOUTH, 0, 0)},
                {new Coordinate(Direction.EAST, 0, 0), new Coordinate(Direction.EAST, 1, 0)},
                {new Coordinate(Direction.WEST, 0, 0), new Coordinate(Direction.WEST, 0, 0)},
                {new Coordinate(Direction.NORTH, 3, 3), new Coordinate(Direction.NORTH, 3, 4)},
                {new Coordinate(Direction.SOUTH, 3, 3), new Coordinate(Direction.SOUTH, 3, 2)},
                {new Coordinate(Direction.EAST, 3, 3), new Coordinate(Direction.EAST, 4, 3)},
                {new Coordinate(Direction.WEST, 3, 3), new Coordinate(Direction.WEST, 2, 3)},
                {new Coordinate(Direction.NORTH, 5, 5), new Coordinate(Direction.NORTH, 5, 5)},
                {new Coordinate(Direction.SOUTH, 5, 5), new Coordinate(Direction.SOUTH, 5, 4)},
                {new Coordinate(Direction.EAST, 5, 5), new Coordinate(Direction.EAST, 5, 5)},
                {new Coordinate(Direction.WEST, 5, 5), new Coordinate(Direction.WEST, 4, 5)}
        });
    }

    @Test
    public void testMoveForward() throws Exception {
        coordinate.moveForward(new Ground(5,5));
        assertEquals(expected, coordinate);
    }

}