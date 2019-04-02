/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2.Ex2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Araújo
 */
public class Ex2 {
    
    public static void run(){
                TicketsLast ticketLast = new TicketsLast(5);
        int nThreads = 10;
        Semaphore sem = new Semaphore(nThreads, true);


        for (int i = 0; i < nThreads; i++) {
            Thread thread = new Seller(sem, ticketLast);
            thread.start();

        }
    }
    
}
