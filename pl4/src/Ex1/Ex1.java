package Ex1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex1 {
	
	public static void Execute() {
		System.out.println("Exercise 1");
		
		int nThreads = 5;
		
		SharedMemory total = new SharedMemory();
		
		int [] intVector = { 1,2,3,4,5,6,7,8,9,10};
		ExecutorService pool = Executors.newFixedThreadPool(nThreads);
		for(int i=0; i < 10;i+=2) {
		pool.execute(new Sum(total, intVector,i));
		}
		
		while(total.getCount()<10);
		
		pool.shutdownNow();
		System.out.println("Final Sum: " + total.getSum());
	}

}
