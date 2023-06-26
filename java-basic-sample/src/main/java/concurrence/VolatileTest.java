package concurrence;

import java.util.Objects;

public class VolatileTest {
    public static volatile Integer a = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                a = 2;
                for (;a == 2;){}
                System.out.println("T1 exit.");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                a = 3;
                System.out.println("T2 exit.");
            }
        });
        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}
