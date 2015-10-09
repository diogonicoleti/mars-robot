package com.dnicoleti.mars.robot.coord;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DirectionTest {

    private Direction direction;
    private Direction expectedRight;
    private Direction expectedLeft;

    public DirectionTest(Direction direction, Direction expectedRight, Direction expectedLeft) {
        this.direction = direction;
        this.expectedRight = expectedRight;
        this.expectedLeft = expectedLeft;
    }

    @Parameters
    public static Iterable<Direction[]> data() {
        return Arrays.asList(new Direction[][]{
                {Direction.NORTH, Direction.EAST, Direction.WEST},
                {Direction.EAST, Direction.SOUTH, Direction.NORTH},
                {Direction.SOUTH, Direction.WEST, Direction.EAST},
                {Direction.WEST, Direction.NORTH, Direction.SOUTH}
        });
    }

    @Test
    public void testLeft() throws Exception {
        assertEquals(expectedLeft, direction.left());
    }

    @Test
    public void testRight() throws Exception {
        assertEquals(expectedRight, direction.right());
    }

}