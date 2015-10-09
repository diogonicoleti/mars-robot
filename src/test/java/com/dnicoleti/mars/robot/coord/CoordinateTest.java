package com.dnicoleti.mars.robot.coord;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.dnicoleti.mars.ground.Ground;

public class CoordinateTest {

    private Coordinate coordinate;

    @Before
    public void setUp() throws Exception {
        coordinate = new Coordinate();
    }

    @Test
    public void testGetDirection() throws Exception {
        assertEquals(Direction.NORTH, coordinate.getDirection());
    }

    @Test
    public void testGetX() throws Exception {
        assertEquals(0, coordinate.getX());
    }

    @Test
    public void testGetY() throws Exception {
        assertEquals(0, coordinate.getY());
    }

    @Test
    public void testRotateLeft() throws Exception {
        coordinate.rotateLeft();
        assertEquals(new Coordinate(Direction.WEST, 0, 0), coordinate);
    }

    @Test
    public void testRotateRight() throws Exception {
        coordinate.rotateRight();
        assertEquals(new Coordinate(Direction.EAST, 0, 0), coordinate);
    }

    @Test
    public void testMoveForward() throws Exception {
        coordinate.moveForward(new Ground(5,5));
        assertEquals(new Coordinate(Direction.NORTH, 0, 1), coordinate);
    }

}