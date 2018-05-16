package Others;

import java.util.concurrent.Exchanger;

public class ThreadExchange {
    private static Exchanger<Integer> exchanger12 = new Exchanger<>();
    private static Exchanger<Integer> exchanger23 = new Exchanger<>();
    private static Exchanger<Integer> exchanger31 = new Exchanger<>();

    private static void execute1(){
        while (true) {
            try {
                exchanger31.exchange(1);
                System.out.println(1);
                Thread.sleep(1000);
                exchanger12.exchange(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static void execute2(){
        while (true) {
            try {
                exchanger12.exchange(2);
                System.out.println(2);
                Thread.sleep(1000);
                exchanger23.exchange(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static void execute3(){
       while (true) {
           try {
               exchanger23.exchange(3);
               System.out.println(3);
               Thread.sleep(1000);
               exchanger31.exchange(3);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(ThreadExchange::execute1);
        Thread t2 = new Thread(ThreadExchange::execute2);
        Thread t3 = new Thread(ThreadExchange::execute3);

        t1.start();
        exchanger31.exchange(1);
        t2.start();
        t3.start();
    }
}
