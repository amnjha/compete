package Others;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadDeadlock {
    public static ExecutorService service = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(SingleThreadDeadlock::submitThread);
        service.submit(t1);
    }

    public static void submitThread(){
        System.out.println("In Thread 1");
        Thread t2= new Thread(()-> System.out.println("In Thread 2"));
        try {
            Future future =service.submit(t2);
            future.get();
            System.out.println("Thread 1 join complete");

            service.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
