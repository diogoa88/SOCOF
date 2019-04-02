package Ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex2 {

	public static void Execute() {
		System.out.println("Exercise 2");

		int nThreads = 5;

		int finalSum = 0;

		int[] intVector = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		ExecutorService pool = Executors.newFixedThreadPool(nThreads);
		List<Future<Integer>> futureList = new ArrayList<>();
		for (int i = 0; i < 10; i += 2) {
			futureList.add(pool.submit(new Sum(intVector, i)));
		}

		
		for(Future<Integer> future : futureList) {
			try {
				
				//Get block the code, just go on when get the result
				//It's Sequential
				finalSum += future.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pool.shutdownNow();
		System.out.println("Final Sum: " + finalSum);
	}
}
