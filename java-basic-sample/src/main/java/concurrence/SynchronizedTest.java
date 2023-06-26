package concurrence;



public class SynchronizedTest {

    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();
        Thread r1 = new Thread(new T1(test));
        Thread r2 = new Thread(new T2(test));
        r1.start();
        r2.start();
    }

    public synchronized void doLock() throws InterruptedException {
        System.out.println("locking");
        Thread.sleep(1000);
        System.out.println("unlock");
    }

    /**
     * 加锁方法
     * @throws InterruptedException
     */
    public synchronized void doLock2() throws InterruptedException {
        System.out.println("locking");
        Thread.sleep(1000);
        System.out.println("unlock");
    }

    /**
     * 不加锁方法
     */
    public void doUnlock() {
        System.out.println("do something");
    }

    /**
     * 用于构造线程的测试类
     */
    static class T1 implements Runnable{
        SynchronizedTest test;
        T1(SynchronizedTest test) {
            this.test = test;
        }

        @Override
        public void run() {
            try {
                test.doLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class T2 implements Runnable{
        SynchronizedTest test;
        T2(SynchronizedTest test) {
            this.test = test;
        }

        @Override
        public void run() {
            try {
                test.doLock2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


