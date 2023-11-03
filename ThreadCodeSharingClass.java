public class ThreadCodeSharingClass {
    
    static void sayHi() {
        System.out.println("Hi");
    }
    
    public static void main(String args[]) throws Exception {
      Thread th = new Thread (new Runnable() {
          public void run() {
              sayHi();
          }
      });
      th.start();
      Thread.sleep(2000);
      Thread th2 = new Thread (new Runnable() {
          public void run() {
              sayHi();
          }
      });
      th2.start();
    }
}
