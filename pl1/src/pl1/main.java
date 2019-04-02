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
public class main {
	
	public main() {}
	
	

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        OrderQueue queue = new OrderQueue();
        for (int i = 0; i < 100; i++) {
            Thread thread = new OrderTaker(queue);
            Thread thread2= new OrderHandler(queue);
            thread.start();
            thread2.start();
        }
        System.out.println("end main");
    }

}
