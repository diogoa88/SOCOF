/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex3;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author user
 */
public class RequestQueue {

	public ConcurrentLinkedQueue<Request> list;

	public RequestQueue() {
		list = new ConcurrentLinkedQueue<>();
	}

	public void addRequest(Request request) {
		list.add(request);
		System.out.println("Request added " + request.getId() + " with " + request.getNumSeats() + " seats");
	}

	public synchronized Request getRequest(int numSeats) {
		for (Request req : list) {
			if (req.getNumSeats() <= numSeats) {
				list.remove(req);
				return req;
			}
		}
		return null;
	}
	
	public void printQueue() {
		String res= "";
		for(Request req : list) {
			res += req.getId() + "-" + req.getNumSeats() + "| ";
		}
		System.out.println(res);
	}

}
