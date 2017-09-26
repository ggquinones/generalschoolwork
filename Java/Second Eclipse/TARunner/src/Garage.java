


/**
 *
 * @author ekou3872
 */
public class Garage {
    
	 //declare fields
    private Car[] cars;
    
    //accessor to the fields
    public Car[] getCars() {
        return cars;
    }
    
    //mutator for field
    public void setCarsElement(Car auto, int index){
        cars[index] = auto;
    }
    
    //see if the bay is empty
    public boolean isEmpty(int k)
    {
        return cars[k] == null;
    }
    
    //print out original state of the lot and updates
    public void displayState()
    {
        for(int k=0; k<cars.length; k++){
            System.out.print(k+"\t");
        }
        System.out.println();
        for(int k=0; k<cars.length; k++){
            if (cars[k]==null){
                System.out.print("E\t");
            }
            else System.out.print("C\t");
        }
        System.out.println();
    }
    
    //method to decide if the car can park in the bay else if full return -1 terminates
    public int park(Car auto){
        int count=0;
        for(int k=0; k<cars.length; k++){
            if (isEmpty(k) == false){
                count++;
            }   else{
                cars[k]=auto;
                return k;
            }
        }
        if(count==cars.length){
            return -1;}
        return -1;
        }
    
    //calculates the elapsed parking time
    public double remove(int index){
        long old = cars[index].getTime();
        long current = System.nanoTime();
        long remove = current-old;
        cars[index]=null;
        return remove;
    }
    
    //non-default constructor, instantiates the cars array to length capacity
    public Garage(int capacity){
        cars = new Car[capacity];
    }
    
}



