package Ex2;

import java.util.concurrent.Callable;

public class Sum implements Callable<Integer>{
	
	private int[] intVector;
	
	private int index;
	
	public Sum( int[] vector, int index) {
		this.intVector=vector;
		this.index=index;
		
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Thread " + Thread.currentThread().getId()+ 
				" add " + this.intVector[index]);
		int res = intVector[index];
		System.out.println("Thread " + Thread.currentThread().getId()+ 
				" add " + this.intVector[index+1]);
		res+=intVector[index+1];
		return res;
	}

}
