import static java.lang.System.out;
import java.util.*;

public class ProducerConsumerTest_3 {
	static Producer[] P = new Producer[3];
	static Consumer[] C = new Consumer[3];

	static class Buffer {
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
			out.printf("Produced by %s: %d\n", Thread.currentThread().getName(), newData);
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
			out.printf("Consumed by %s: %d\n", Thread.currentThread().getName(),  data);
			return data;
		}
	}

	static class Producer extends Thread {
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

				for (int i = 0; i < 3; i++) {
					out.printf("P[%d] = %s\n", i, P[i].getState().toString());
				}
				for (int i = 0; i < 3; i++) {
					out.printf("C[%d] = %s\n", i, C[i].getState().toString());
				}
			}
		}
	}

	static class Consumer extends Thread {
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

				for (int i = 0; i < 3; i++) {
					out.printf("P[%d] = %s\n", i, P[i].getState().toString());
				}
				for (int i = 0; i < 3; i++) {
					out.printf("C[%d] = %s\n", i, C[i].getState().toString());
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		
		Producer p1 = new Producer(buffer, "P1");
		Producer p2 = new Producer(buffer, "P2");
		Producer p3 = new Producer(buffer, "P3");
		Consumer c1 = new Consumer(buffer, "C1");
		Consumer c2 = new Consumer(buffer, "C2");
		Consumer c3 = new Consumer(buffer, "C3");

		P[0] = p1; P[1] = p2; P[2] = p3;
		C[0] = c1; C[1] = c2; C[2] = c3;

		for (int i = 0; i < 3; i++) {
			P[i].start();
			C[i].start();
		}
	}
}