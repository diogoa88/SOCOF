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
public class OrderTaker extends Thread {

    private OrderQueue queue;

    public OrderTaker(OrderQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
            //Scanner read = new Scanner(System.in);
            //System.out.println("Write a number for the queue:");
            //int number = Integer.parseInt(read.nextLine());           
            //Order order = new Order(number);
            
            Order order = new Order((int) (Math.random() * 50 + 1));
            queue.addOrder(order);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }

}
