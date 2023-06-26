package thread;

/**
 * 主线程等待子线程执行完毕的实现方案
 * 1. thread.join() 等待线程执行完毕
 * 2. 子线程交给线程池，等待线程池中所有线程完成后关闭线程池
 * 3. CountDownLatch 锁
 */
public class MainWaitSubTest {
}
