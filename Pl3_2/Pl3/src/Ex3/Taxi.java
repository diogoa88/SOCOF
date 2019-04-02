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
public class Taxi extends Thread{
    
    public int numSeats;

    public Taxi(int numSeats) {
        this.numSeats = numSeats;
    }
    
    
    @Override
    public void run(){
        System.out.println("Taxi " + this.getId() + " start!");
    }
    
}
