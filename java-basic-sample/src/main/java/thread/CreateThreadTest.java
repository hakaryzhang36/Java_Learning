package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThreadTest {
    static class MyThread_1 implements Runnable{
        @Override
        public void run() {
            System.out.println("MyThread 1");
        }
    }

    static class MyThread_2 extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread 2");
        }
    }

    static class MyThread_3 implements Callable<Integer> {
        @Override
        public Integer call() {
            System.out.println("MyThread 3");
            return 1;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> threadTask_3 = new MyThread_3();
        // FutureTask 对 Callable 对象和返回值（泛型）进行封装
        FutureTask<Integer> ft = new FutureTask<>(threadTask_3);
        Thread t = new Thread(ft);
        t.start();
        System.out.println((Integer) ft.get());
    }
}
