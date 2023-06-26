package concurrence;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumberLock {
    static volatile Integer status = 0;

    static Runnable r1 = new Runnable(){
        @Override
        public void run() {
            for (int i = 1; i <= 9; i+=2) {
                while (status != 0) {}
                System.out.println(i);
                status = 1;
            }
        }
    };

    static Runnable r2 = new Runnable(){
        @Override
        public void run() {
            for (int i = 2; i <= 10; i+=2) {
                while (status != 1) {}
                System.out.println(i);
                status = 0;
            }
        }
    };

    static ReentrantLock reentrantLock = new ReentrantLock();
    static Condition conditionA = reentrantLock.newCondition();
    static Condition conditionB = reentrantLock.newCondition();

    static Runnable r3 = new Runnable() {
        @Override
        public void run() {
            reentrantLock.lock();
            for (int i = 1; i <= 9; i+=2) {
                try {
                    System.out.println(i);
                    conditionB.signal();    // 唤醒A
                    conditionA.await();     // 等待唤醒
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            reentrantLock.unlock();
        }
    };

    static Runnable r4 = new Runnable() {
        @Override
        public void run() {
            reentrantLock.lock();
            for (int i = 2; i <= 10; i+=2) {
                try {
                    System.out.println(i);
                    conditionA.signal();    // 唤醒A
                    conditionB.await();     // 等待唤醒
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            reentrantLock.unlock();
        }
    };

    public static void main(String[] args) {
        new Thread(r3).start();
        new Thread(r4).start();
    }
}
