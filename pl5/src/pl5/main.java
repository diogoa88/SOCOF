package pl5;

public class main {

	public static void main(String[] args) {

		LockFreeQueue<Integer> queue = new LockFreeQueue<Integer>();

		for (int i = 0; i < 100; i++) {
			/*
			new Thread() {
				@Override
				public void run() {
					Node<Integer> n = new Node<Integer>(i);
					queue.push(n); 
				}
			}.start();
			*/
			new Aux(i, queue).start();
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		queue.print();
		
		for (int j = 0; j < 95; j++) {
			new Thread() {
				@Override
				public void run() {
					queue.pop();
				}
			}.start();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		queue.print();

	}

}
