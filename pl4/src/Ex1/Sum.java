package Ex1;

public class Sum implements Runnable{
	
	private SharedMemory total;
	
	private int[] intVector;
	
	private int index;
	
	public Sum(SharedMemory total, int[] vector, int index) {
		this.total = total;
		this.intVector=vector;
		this.index=index;
		
	}

	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getId()+ 
				" add " + this.intVector[index]);
		total.addParcialSum(this.intVector[index]);
		System.out.println("Thread " + Thread.currentThread().getId()+ 
				" add " + this.intVector[index+1]);
		total.addParcialSum(this.intVector[index+1]);
	}

}
