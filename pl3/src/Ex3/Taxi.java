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
public class Taxi extends Thread {

	private int numSeats;

	private RequestQueue queue;

	public Taxi(int numSeats, RequestQueue queue) {
		this.numSeats = numSeats;
		this.queue = queue;
	}

	public int getNumSeats() {
		return numSeats;
	}

	@Override
	public void run() {
		System.out.println("Taxi " + this.getId() + " start with " + this.getNumSeats() + " seats");
		boolean exit = false;
		while (!exit) {
			this.queue.printQueue();
			Request req = this.queue.getRequest(this.getNumSeats());
			if (req == null) {
				exit = true;
			} else {
				System.out
						.println("Taxi " + this.getId() + " get Request " + req.getId() + " with " + req.getNumSeats());
				long random = (long) (Math.random() * 5000 + 1);
				try {
					this.sleep(random);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Taxi " + this.getId() + " with " + this.getNumSeats() + " seats transport Request"
						+ req.getId() + " with " + req.getNumSeats() + " seats");
			}
		}
		System.out.println("Taxi " + this.getId() + " end!");
	}


}
