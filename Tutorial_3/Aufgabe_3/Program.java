import java.util.concurrent.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public final class Program {
  public static void main(String[] args) {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    
    Runnable task = () -> {
      Date now = new Date();
      String timeStamp = new SimpleDateFormat("HH-mm-ss").format(now);
      System.out.println(timeStamp);
    };
    
    executor.scheduleWithFixedDelay(task, 0, 5, TimeUnit.SECONDS);
  }
}
