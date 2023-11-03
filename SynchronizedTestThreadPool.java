import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  

public class SynchronizedTestThreadPool {
    
    static class WorkerThread implements Runnable {  
        private String message;  
        public WorkerThread(String s){  
            this.message=s;  
        }  
         public void run() {  
             WorkerThread.performActions(this.message);
        } 
        public static synchronized void performActions(String message) {
            System.out.println(Thread.currentThread().getName()+" (Start) message = "+message);  
            try {  
                    Thread.sleep(2000); 
                } catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
            System.out.println(Thread.currentThread().getName()+" (End) message = "+message); 

        }
    }  
    
     public static void main(String[] args) {  
        ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads  
        for (int i = 0; i < 10; i++) {  
            Runnable worker = new WorkerThread("" + i);  
            executor.execute(worker);//calling execute method of ExecutorService  
          }  
        executor.shutdown();  
        while (!executor.isTerminated()) {   }  
  
        System.out.println("Finished all threads");  
    }  
 }  
