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
public class Request extends Thread {

    
    private int numSeats ;
    
    private RequestQueue queue;
    

    public Request(int numSeats, RequestQueue queue) {
        this.numSeats = numSeats;
        this.queue = queue;
    }
    
    
    public int getNumSeats() {
    	return this.numSeats;
    }
   
    
    @Override
    public void run(){
        System.out.println("Request start for thread " + this.getId() + 
        		" for " + this.numSeats + " seats");
        this.queue.addRequest(this);
    }
    
}
