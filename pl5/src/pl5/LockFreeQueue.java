package pl5;

import java.util.concurrent.atomic.AtomicReference;

public class LockFreeQueue<T> {

	public AtomicReference<Node<T>> head;
	public AtomicReference<Node<T>> tail;

	public LockFreeQueue() {
		Node<T> sentinel = new Node<T>(null);
		head = new AtomicReference<Node<T>>(sentinel);
		tail = new AtomicReference<Node<T>>(sentinel);
	}

	public void push(Node<T> newNode) {
		Node<T>oldTail;
		while(true) {
			oldTail = this.tail.get();
			if(oldTail.next.compareAndSet(null, newNode)) {
				if(tail.compareAndSet(oldTail, newNode)) {
					return;
				}
			}
		}

	}

	public Node<T> pop() {
		Node<T> oldHead; 
		while(true) {
			oldHead = this.head.get();
			if(head.compareAndSet(oldHead, oldHead.next.get())) {
				return oldHead;
			}
		}
	}

	public void print() {
		String res = "";
		Node<T> node = this.head.get();
		while (node != null) {
			node = node.next.get();
			if (node != null)
				res += node.value.toString() + " ";
		}
		System.out.println(res);
	}
	
}
