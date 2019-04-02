/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author user
 */
public class Car extends Thread {

    private Semaphore peopleLimit;

    private Semaphore rollercoasterStart;
    
    private Semaphore mutex;

    public Car(Semaphore peopleLimit, Semaphore rollercoasterStart, Semaphore mutex) {
        this.peopleLimit = peopleLimit;
        this.rollercoasterStart = rollercoasterStart;
        this.mutex=mutex;
    }

    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            try {
                // If don't acquire the lock in 5s, return false
                if (rollercoasterStart.tryAcquire(5, TimeUnit.SECONDS)) {
                    System.out.println("The car is start");
                    Thread.sleep(500); //Travel time
                    System.out.println("The car stoped");
                    peopleLimit.release(10);//Allow more 10 persons
                    mutex.release();
                } else {
                    exit = true;
                    System.out.println("car is out");
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
