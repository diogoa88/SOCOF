/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex3;

import java.util.Random;

/**
 *
 * @author user
 */
public class Main {
    
    public static void Execute(){
        int NUM_TAXI = 2;
        int NUM_REQUEST = 5;
        
        RequestQueue queue = new RequestQueue();
        Random numSeats = new Random();
        
       
        for (int i = 0; i < NUM_REQUEST; i++) {
            Request reqThread = new Request(numSeats.nextInt(4) + 1, queue);
            reqThread.start();
            
        }
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        for (int i = 0; i < NUM_TAXI; i++) {
            Thread taxi = new Taxi(numSeats.nextInt(4) + 1, queue);      
            taxi.start();
        }
    }
    
}
