/*
  Created by Oliver on 05/02/2018.
  Written by Oliver Bathurst <oliverbathurst12345@gmail.com>
 */
package uk.ac.reading.oliver.bathurst;

import org.jcsp.lang.CSProcess;
import org.jcsp.lang.One2OneChannel;

/**
 * This class infinitely writes a single integer to the depart channel to simulate departing cars
 * The channel is read by Control and spaces managed
 */
class Departs implements CSProcess {
    private final One2OneChannel depart;

    Departs(One2OneChannel depart) {
        this.depart = depart;
    }

    @Override
    public void run() {
        while(true){
            depart.out().write("generic depart");
        }
    }
}