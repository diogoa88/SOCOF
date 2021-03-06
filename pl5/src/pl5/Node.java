package pl5;

import java.util.concurrent.atomic.AtomicReference;

public class Node<T> {
	
	public T value;
	public AtomicReference<Node<T>> next;

	public Node(T value) {
		this.value = value;
		this.next = new AtomicReference<Node<T>>(null);
	}
}