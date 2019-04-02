package Ex1;

public class SharedMemory {
	
	private int sum;
	
	private int count;
	
	public SharedMemory() {
		this.sum = 0;
		this.count = 0;
	}
	
	public synchronized void addParcialSum(int value) {
		sum+=value;
		count++;
	}
	
	public synchronized int getSum() {
		return sum;
	}
	
	public synchronized int getCount() {
		return count;
	}

}
