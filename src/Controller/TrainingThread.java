
package Controller;

import Classifiers.Classifier;
import Resources.House;
import java.util.List;

/**
 * A runnable training class that will allow the main controller class to 
 * train multiple classification objects in parallel.
 * 
 * @author Matthew Lai and Arun Singh
 */
public class TrainingThread implements Runnable {
    
    List<House> houses;
    Classifier c;
    
    /**
     * Constructor that takes in a List of House objects and trains the given
     * classification method.
     * 
     * @param houses The List of Houses to be used as training data.
     * @param c The classification object that will be trained.
     */
    public TrainingThread(List<House> houses, Classifier c)
    {
        this.houses = houses;
        this.c = c;
    }
    
    @Override
    public void run() {
        houses.stream().forEach(h -> c.train(h));
    }
    
}
