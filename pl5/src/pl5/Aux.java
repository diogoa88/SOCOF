package pl5;

public class Aux extends Thread{
	
	public int i;
	
	public LockFreeQueue<Integer> queue;
	
	public Aux(int i, LockFreeQueue<Integer> queue) {
		this.i= i;
		this.queue = queue;
	}

	@Override
	public void run() {
		Node<Integer> n = new Node<Integer>(i);
		queue.push(n); 
	}
}
