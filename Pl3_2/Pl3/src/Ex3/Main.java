/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex3;

/**
 *
 * @author user
 */
public class Main {
    
    public static void Execute(){
        int NUM_TAXI = 10;
        int NUM_REQUEST = 100;
        
        for (int i = 0; i < NUM_TAXI; i++) {
            Thread taxi = new Taxi(3);      
            taxi.start();
        }
        
        for (int i = 0; i < NUM_REQUEST; i++) {
            Thread reqThread = new Request(3);
            reqThread.start();
            
        }
    }
    
}