import static java.lang.System.out;
import java.util.*;

class Buffer {
	private int data;
	private boolean empty;

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
		notify();		//this.notify();
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
		notify();		// this.notify();
		out.println("Consumed: " + data);
		return data;
	}
}

class Producer extends Thread {
	private final Buffer buffer;

	Producer(Buffer buffer) { this.buffer = buffer; }

	@Override
	public void run() {
		Random rand = new Random();
		while (true) {
			int n = rand.nextInt(1000);
			buffer.produce(n);
		}
	}
}

class Consumer extends Thread {
	private final Buffer buffer;

	Consumer(Buffer buffer) { this.buffer = buffer; }

	@Override
	public void run() {
		int data;

		while (true) {
			data = buffer.consume();
		}
	}
}

public class ProducerConsumerTest {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		Producer p = new Producer(buffer);
		Consumer c = new Consumer(buffer);
		p.start();
		c.start();
	}
}

