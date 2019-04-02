/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2.Ex2;

/**
 *
 * @author Araújo
 */
public class TicketsLast {
    
    private int ticketsLast;

    public TicketsLast(int TicketsLast) {
        this.ticketsLast = TicketsLast;
    }

    public int getTicketsLast() {
        return ticketsLast--;
    }
    
    
}
