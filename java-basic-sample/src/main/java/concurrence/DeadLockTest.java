package concurrence;

public class DeadLockTest {
    public static Object obj1 = new Object();
    public static Object obj2 = new Object();

    public static void main(String[] args) {
        // t1 先锁 obj1 再锁 obj2
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj1) {
                    System.out.println("t1 get obj1.");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    // 保持并请求
                    synchronized (obj2) {
                        System.out.println("t1 get obj2.");
                    }
                }
            }
        });
        // t2 先锁 obj2 再锁 obj1
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj2) {
                    System.out.println("t2 get obj2.");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    // 保持并请求
                    synchronized (obj1) {
                        System.out.println("t2 get obj1.");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }


}
