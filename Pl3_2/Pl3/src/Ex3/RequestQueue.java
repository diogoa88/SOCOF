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
    
    
    public void addRequest(Request request){
        list.add(request);
        System.out.println("Request added");
    }
    
}