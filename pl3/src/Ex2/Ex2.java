/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author user
 */
public class Ex2 {
    
    public static void Execute(){
        
        Semaphore peopleLimit = new Semaphore(10, true);
        Semaphore rollercoasterStart = new Semaphore(0,true);
        
        Semaphore mutex = new Semaphore(1,true);
        
        Car t = new Car(peopleLimit, rollercoasterStart, mutex);
        t.start();
        
        for (int i = 0; i <51; i++) {
            Person t2 = new Person(peopleLimit, rollercoasterStart,mutex);
            t2.start();
        }
    } 
}
