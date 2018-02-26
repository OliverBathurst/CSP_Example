/*
  Created by Oliver on 05/02/2018.
  Written by Oliver Bathurst <oliverbathurst12345@gmail.com>
 */
package uk.ac.reading.oliver.bathurst;
import org.jcsp.lang.CSProcess;
import org.jcsp.lang.One2OneChannel;

/**
 * This class indefinitely writes a single phrase to the arrive channel to simulate arriving cars
 * The channel is read by Control and spaces managed
 */
class Arrivals implements CSProcess {
    private final One2OneChannel arrive;

    Arrivals(One2OneChannel arrive){
        this.arrive = arrive;
    }

    /**
     * Arrivals -> arrive -> Arrivals
     * Emulates background cars arriving at the car park
     */
    @Override
    public void run() {
        while(true){
            arrive.out().write("generic arrive");
        }
    }
}