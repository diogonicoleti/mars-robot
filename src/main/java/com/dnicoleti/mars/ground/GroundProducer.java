package com.dnicoleti.mars.ground;

import javax.enterprise.inject.Produces;

public class GroundProducer {

    /**
     * Returns a new Mars ground with size <em>5 x 5</em>
     * @return a new mars ground
     */
    @Produces
    public Ground getMarsGround() {
        return new Ground(5, 5);
    }

}
