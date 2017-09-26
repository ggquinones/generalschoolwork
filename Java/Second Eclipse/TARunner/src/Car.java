
	public class Car {
		//Declare fields
	    private long timeIn;
	    
	    //getter for timeIn
	    public long getTime(){
	        return timeIn;
	    }
	    
	    //set old time to use later
	    public Car(){
	        timeIn = System.nanoTime();
	    }
		}

