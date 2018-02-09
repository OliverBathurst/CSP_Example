/*
  Created by Oliver on 05/02/2018.
  Written by Oliver Bathurst <oliverbathurst12345@gmail.com>
 */
package uk.ac.reading.oliver.bathurst;
import jcsp.lang.CSProcess;
import jcsp.lang.ints.One2OneChannelInt;

/**
 * This class controls the spaces within the car park, reads from both depart and arrive channels
 * to reduce or increase available spaces.
 */
class Control implements CSProcess {
    private final One2OneChannelInt arrive, depart, spacesLeftChannel;
    private final Space[] spaces = new Space[100];
    private int spacesLeft = 100;

    Control(One2OneChannelInt arrive, One2OneChannelInt depart, One2OneChannelInt spacesLeftChannel) {
        this.arrive = arrive;
        this.depart = depart;
        this.spacesLeftChannel = spacesLeftChannel;
    }
    public void run(){
        while(true){
            if(arrive.read() == 1 && spacesLeft != 0){
                spacesLeft--;
                System.out.println("Spaces: " + spacesLeft);
                spacesLeftChannel.write(spacesLeft);
            }
            if(depart.read() == 1 && spacesLeft != spaces.length){
                spacesLeft++;
                System.out.println("Spaces: " + spacesLeft);
                spacesLeftChannel.write(spacesLeft);
            }
        }
    }
}