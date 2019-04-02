/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2.Ex2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Araújo
 */
public class Seller extends Thread{
    
    private Semaphore sem;
    
    private TicketsLast ticketsLast ;

    public Seller(Semaphore sem, TicketsLast number) {
        this.sem = sem;
        this.ticketsLast = number;
    }
    
    
    
   @Override
   public void run(){
        try {
            sem.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Seller.class.getName()).log(Level.SEVERE, null, ex);
        }
        int ticket;
        ticket = ticketsLast.getTicketsLast();
        if(ticket>0) System.out.println("Selling ticket number:" + ticket);
        else System.out.println("Don't have tickets to sell");
        sem.release();
   } 
    
}
