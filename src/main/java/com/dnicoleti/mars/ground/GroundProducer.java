package com.dnicoleti.mars.ground;

import javax.enterprise.inject.Produces;

public class GroundProducer {

    @Produces
    public Ground getMarsGround() {
        return new Ground(5, 5);
    }

}
