import java.util.concurrent.*;
import java.util.*;
import static java.lang.System.out;

public class HelloHP_3 {
	static int[] done = new int[4];

	class Party extends Thread {
		int duration;
		int id;
		String name;
		CyclicBarrier barrier;

		Party(int duration, CyclicBarrier barrier, String name, int id) {
			super(name);
			this.name = name;
			this.duration = duration;
			this.barrier = barrier;
			this.id = id;
		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < 3; i++) {
					out.printf("%s: i = %d is started\n", Thread.currentThread().getName(), i);
					Thread.sleep(duration);
					out.printf("%s: i = %d is calling await()\n", Thread.currentThread().getName(), i);
					barrier.await();
					//out.printf("%s: i = %d has started running again\n", Thread.currentThread().getName(), i);
				}
				done[id] = 1;
			} catch (InterruptedException | BrokenBarrierException e) {
			}
		}
	}

	class Check implements Runnable {
		public void run() {
			out.println("------ MIGRATION ------");
		}
	}

	void runThem() throws InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(4, new Check());
		Party first = new Party(1000, barrier, "PARTY-1", 0);
		Party second = new Party(1000, barrier, "PARTY-2", 1);
		Party third = new Party(1000, barrier, "PARTY-3", 2);
		Party fourth = new Party(1000, barrier, "PARTY-4", 3);

		first.start();
		second.start();
		third.start();
		fourth.start();

		first.join();
		second.join();
		third.join();
		fourth.join();
	}

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		HelloHP_3 app = new HelloHP_3();
		app.runThem();

		out.println("*****  Main has finished *****");
	}
}