/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl1;

/**
 *
 * @author Araújo
 */
public class OrderHandler extends Thread {

    private OrderQueue queue;

    public OrderHandler(OrderQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Order order = queue.removeOrder();
        
    }

}
