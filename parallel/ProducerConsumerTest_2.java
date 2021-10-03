import static java.lang.System.out;
import java.util.*;

class Buffer {
	private int data;
	boolean empty;

	Buffer() { this.empty = true;	}

	synchronized void produce(int newData) {
		while (!empty) {
			try {
				wait();		//this.wait();
			} catch (InterruptedException e) {
			}
		}

		data = newData;
		empty = false;
		notifyAll();		//this.notify();
		out.println("Produced: " + newData);
	}

	synchronized int consume() {
		while (empty) {
			try {
				wait();		// this.wait();
			} catch (InterruptedException e) {
			}
		}

		empty = true;
		notifyAll();		// this.notify();
		out.println("Consumed: " + data);
		return data;
	}
}

class Producer extends Thread {
	private final Buffer buffer;
	
	Producer(Buffer buffer, String name) { 
		this.buffer = buffer;
		setName(name);
	}

	@Override
	public void run() {
		Random rand = new Random();
		while (true) {
			int n = rand.nextInt(1000);
			buffer.produce(n);
			out.printf("Done %s: empty = %b\n", Thread.currentThread().getName(), buffer.empty);
		}
	}
}

class Consumer extends Thread {
	private final Buffer buffer;

	Consumer(Buffer buffer, String name) { 
		this.buffer = buffer;
		setName(name);
	}

	@Override
	public void run() {
		int data;

		while (true) {
			data = buffer.consume();
			out.printf("Done %s: empty = %b\n", Thread.currentThread().getName(), buffer.empty);
		}
	}
}

public class ProducerConsumerTest_2 {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		Producer p1 = new Producer(buffer, "P1");
		Producer p2 = new Producer(buffer, "P2");
		Producer p3 = new Producer(buffer, "P3");
		Consumer c1 = new Consumer(buffer, "C1");
		Consumer c2 = new Consumer(buffer, "C2");
		Consumer c3 = new Consumer(buffer, "C3");
		p1.start(); p2.start(); p3.start();
		c1.start(); c2.start(); c3.start();
	}
}

