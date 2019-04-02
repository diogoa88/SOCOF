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
public class Person extends Thread {

    private Semaphore peopleLimit;

    private Semaphore rollercoasterStart;

    private Semaphore mutex;

    public Person(Semaphore peopleLimit, Semaphore rollercoasterStart, Semaphore test) {
        this.peopleLimit = peopleLimit;
        this.rollercoasterStart = rollercoasterStart;
        this.mutex = test;
    }

    @Override
    public void run() {
        try {
            peopleLimit.acquire();
            System.out.println("Thread:" + this.getId());
            mutex.acquire();    
            //If no more can entry, alert to start the car
            if (peopleLimit.availablePermits() == 0) {
                rollercoasterStart.release();
            }else{
                mutex.release();
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
