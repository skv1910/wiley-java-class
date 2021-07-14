package wiley.week4;

import java.util.ArrayList;
import java.util.List;

public class FibUsingThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fibonacci fib = new Fibonacci(10);
		Thread t1 = new Thread(fib);
		Thread t2 = new Thread(fib);

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
			System.out.println(fib.getSeries());
			System.out.println(fib.sum);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Fibonacci implements Runnable{

	private List<Integer> series = new ArrayList<Integer>();;	
	int n=0,i=0;
	int a=1,b=1;
	int sum=0;
	public Fibonacci(int n) {
		super();
		this.n = n;
		series.add(a);
		series.add(b);
	}
	@Override
	public void run() {
		if(i==0) {
			synchronized(FibUsingThread.class) { 
				System.out.println(Thread.currentThread().getName() + " ---> "+ sum + " + " + a + " = " + (sum+a) );
				sum+=a;
				i++;
			}
			try {
				Thread.sleep(100);;
			}catch (InterruptedException inEx){
				System.err.println(inEx);
			}
		}
		if(i==1){
			synchronized(FibUsingThread.class) { 
				System.out.println(Thread.currentThread().getName() + " ---> "+ sum + " + " + b + " = " + (sum+b) );
				sum+=b;
				i++;
			}
			try {
				Thread.sleep(100);;
			}catch (InterruptedException inEx){
				System.err.println(inEx);
			}
		}

		while(i<n) {
			synchronized(FibUsingThread.class) { 
				b=a+b;
				a=b-a;
				series.add(b);
				System.out.println(Thread.currentThread().getName() + " ---> "+ sum + " + " + b + " = " + (sum+b) );
				sum+=b;
				i++;
			}
			try {
				Thread.sleep(100);;
			}catch (InterruptedException inEx){
				System.err.println(inEx);
			}

		}
		//System.out.println(getSeries());

	}
	public List<Integer> getSeries(){
		return series;
	}

}
