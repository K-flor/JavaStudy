import java.util.concurrent.*;
import java.util.*;
import static java.lang.System.out;

class Party extends Thread {
	int duration;
	CyclicBarrier barrier;

	Party(int duration, CyclicBarrier barrier, String name) {
		super(name);
		this.duration = duration;
		this.barrier = barrier;
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
		} catch (InterruptedException | BrokenBarrierException e) {
		}
	}
}

public class HelloHP_0 {
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		CyclicBarrier barrier = new CyclicBarrier(4);
		Party first = new Party(1000, barrier, "PARTY-1");
		Party second = new Party(1000, barrier, "PARTY-2");
		Party third = new Party(1000, barrier, "PARTY-3");
		Party fourth = new Party(1000, barrier, "PARTY-4");

		first.start();
		second.start();
		third.start();
		fourth.start();

		out.println("*****  Main has finished *****");
	}
}