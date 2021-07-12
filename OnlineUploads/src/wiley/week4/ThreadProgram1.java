package wiley.week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ThreadProgram1 {
	
	public static void main(String[] args) {

        EmpService empService = new EmpService();

        Thread empThread1 = new Thread(empService);
        Thread empThread2 = new Thread(empService);
        
//        empThread1.setPriority(10);
//        empThread2.setPriority(10);
        empThread1.start();
        empThread2.start();
//		empThread2.run();
//		empThread1.run();
     
        System.out.println(empService.getIntegrs());
		
	}

}

class EmpService implements Runnable{

	private List<Integer> integers = new ArrayList<Integer>();;	
	int i=0;
	@Override
	public void run() {
		//integers = new ArrayList<Integer>();
		for( ;i<10;) {
			integers.add(i++);
            try {
                Thread.sleep(100);
            }catch (InterruptedException inEx){
                System.err.println(inEx);
            }
			System.out.println(Thread.currentThread().getName() + " -- "+i);
		}
		System.out.println(getIntegrs());
		
	}
	public List<Integer> getIntegrs(){
		return integers;
	}
	
}