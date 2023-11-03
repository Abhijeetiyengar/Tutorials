public class SimpleThreadClass {
    public static void main(String args[]) {
      Thread th = new Thread (new Runnable() {
          public void run() {
              System.out.println("Hello");
          }
      });
      th.start();
    }
}
