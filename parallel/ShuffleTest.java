import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

class TspThread1 implements Runnable {
	Thread t;
	int pop_size;
	int n ; 

	TspThread1(int pop_size, int n) {
		this.pop_size = pop_size;
		this.n = n;
		t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		int[][] pop = new int[pop_size][n];
		for(int i=0; i < pop_size; i++) {
			CopyOnWriteArrayList<Integer> range = new CopyOnWriteArrayList<Integer>();
			
			for(int j = 0; j < n; j++)
				range.add(j);
			
			Collections.shuffle(range);
			pop[i] = range.parallelStream().mapToInt(j -> j).toArray();
		}
	}
}

class TspThread2 implements Runnable {
	Thread t;
	int pop_size;
	int n ; 
	
	TspThread2(int pop_size, int n) {
		this.pop_size = pop_size;
		this.n = n;
		t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		int[][] pop = new int[pop_size][n];
		for(int i=0; i<pop_size; i++) {
			List<Integer> range = IntStream.range(0, n).boxed().collect(Collectors.toList());
			Collections.shuffle(range); 
			pop[i] = range.parallelStream().mapToInt(j->j).toArray();
		}
	}
}

public class ShuffleTest{
	public static void main(String[] args) {
		int pop_size = 10000;
		int n = 250;

// ---------------------------------------------------------------------------------------- 
		long start2 = System.currentTimeMillis();
		TspThread2[] ths2 = new TspThread2[10];
		for(int i = 0; i < ths2.length; i++){
			ths2[i] = new TspThread2(pop_size, n);
		}
		
		for(int i=0; i<ths2.length; i++){
			try {
				ths2[i].t.join();
				System.out.println("[#]  "+i+"번째 thread join!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long end2 = System.currentTimeMillis();

		System.out.println("Take Time -- TspThread2 " + (long) ((end2 - start2) / 1000.0) );

// ---------------------------------------------------------------------------------------- 
		long start = System.currentTimeMillis();
		TspThread1[] ths1 = new TspThread1[10];
		for(int i = 0; i < ths1.length; i++){
			ths1[i] = new TspThread1(pop_size, n);
		}
		
		for(int i=0; i<ths1.length; i++){
			try {
				ths1[i].t.join();
				System.out.println("[#]  "+i+"번째 thread join!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();

		System.out.println("Take Time -- TspThread1 " + (long) ((end - start) / 1000.0) );

// ---------------------------------------------------------------------------------------- 
		start2 = System.currentTimeMillis();
		ths2 = new TspThread2[10];
		for(int i = 0; i < ths2.length; i++){
			ths2[i] = new TspThread2(pop_size, n);
		}
		
		for(int i=0; i<ths2.length; i++){
			try {
				ths2[i].t.join();
				System.out.println("[#]  "+i+"번째 thread join!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		end2 = System.currentTimeMillis();

		System.out.println("Take Time -- TspThread2 " + (long) ((end2 - start2) / 1000.0) );


	}
}