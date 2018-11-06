public final class Program {
  public static void main(String[] args) {
    Runnable task = () -> {
      String threadName = Thread.currentThread().getName();
      System.out.println("Start " + threadName);
      try {
        Thread.sleep(5000);
      } catch(InterruptedException ex) {
        System.out.println("Interrupted in " + threadName);
      }
      System.out.println("End " + threadName);
    };
    
    for(int i = 0; i < 10; i++) {
      Thread thread = new Thread(task);
      thread.start();
    }
  }
}
