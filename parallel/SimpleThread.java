import java.util.*;

class Th implements Runnable {
	int[] a;
	Thread t;

	Th(int[] a){
		this.a = a;
		t = new Thread(this);
		t.start();
	}

	public void run(){
		for(int i=0; i<a.length; i++){
			a[i] = a[i] * 3;
		}
	}
}

class Th2 implements Runnable {
	int[] b;

	Th2(int[] b){
		this.b = b;
	}

	public void run(){
		for(int i=0; i<b.length; i++){
			b[i] = b[i] - 10;
		}
	}
}

public class SimpleThread{
	public static void main(String[] args){
		int[] aee = {3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(aee));
		
		Th tt = new Th(aee);
		try{
			tt.t.join();
		}
		catch (InterruptedException e){
		}
		System.out.println(Arrays.toString(aee));


		Thread ttt = new Thread(new Th2(aee));
		ttt.start();
		try{
			ttt.join();
		}
		catch (InterruptedException e){
		}
		System.out.println(Arrays.toString(aee));
	}
}