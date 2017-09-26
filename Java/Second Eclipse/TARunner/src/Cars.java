/*
 *Koundo Ephy
 *CS 160 Fall 2015
 *Project 4: Parking Management
 *The Car class shall tell us the arrival time the parking bay was occupied.
 */

/**
 *
 * @author ekou3872
 */
public class Cars {
    
	// field
    private long timeIn;
    
    // accessor method for timeIn field
    public long getTime(){
        
        return timeIn;
    }
    
    // no-arg constructor\
    public Cars(){
        timeIn = System.nanoTime();
    }
}