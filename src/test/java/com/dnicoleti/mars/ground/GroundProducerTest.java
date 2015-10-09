package com.dnicoleti.mars.ground;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class GroundProducerTest {

    private static GroundProducer producer;

    @BeforeClass
    public static void setUpClass() {
        producer = new GroundProducer();
    }

    @Test
    public void testGetMarsGround() throws Exception {
        assertEquals(new Ground(5,5), producer.getMarsGround());
    }

}