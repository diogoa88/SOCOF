package pl1;

import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Araújo
 */
public class OrderQueue {

    // private LinkedList<Order> list;
    private ConcurrentLinkedQueue<Order> list;

    public OrderQueue() {
        this.list = new ConcurrentLinkedQueue<Order>();
    }

    /*Exercicio 2 
    public synchronized void addOrder(Order order) {
        this.list.add(order);
        notifyAll();
        System.out.println("added: " + order.getNumber());
    }

    public synchronized Order removeOrder(){
        while(list.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(OrderQueue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Order last = this.list.removeLast();
        System.out.println("Order:" + last.getNumber() + " removed.");
        return last;
    }
     */
    public void addOrder(Order order) {
        this.list.add(order);
        System.out.println("added: " + order.getNumber());
    }

    public Order removeOrder() {
        Order last = null;
        try {
             last = this.list.remove();
            System.out.println("Order:" + last.getNumber() + " removed.");
        } catch (NoSuchElementException e) {
        }
        return last;

    }
}
