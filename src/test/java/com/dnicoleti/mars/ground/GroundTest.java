package com.dnicoleti.mars.ground;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class GroundTest {

    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    private static Ground ground;

    @BeforeClass
    public static void setProducer() {
        ground = new Ground(WIDTH, HEIGHT);
    }

    @Test
    public void testGetWidth() throws Exception {
        assertEquals(WIDTH, ground.getWidth());
    }

    @Test
    public void testGetHeight() throws Exception {
        assertEquals(HEIGHT, ground.getHeight());
    }
}