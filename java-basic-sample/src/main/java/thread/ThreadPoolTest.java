package thread;


import java.util.concurrent.*;

public class ThreadPoolTest {
    static class Task implements Runnable {

        int i;

        Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                System.out.println("Doing task " + i);
                Thread.sleep(1000);
                System.out.println("Finish task " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
          普通线程池
         */
        ExecutorService executor = new ThreadPoolExecutor(
                3,
                3,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadPoolExecutor.AbortPolicy()
        );


//        for (int i = 1; i <= 5; i++) {
//            try {
//                // 第五个任务会执行饱和策略
//                executor.execute(new Task(i));
//            }
//            catch (Exception e) {
//                System.out.println(e);
//            }
//        }


        /*
          定时线程池
          不用指定队列类型，因为只能是 DelayWorkQueue
         */
        ScheduledExecutorService scheduledExecutor = new ScheduledThreadPoolExecutor(
                3,
                new ThreadPoolExecutor.AbortPolicy()
        );

        // 设置延迟任务
        // 注意：这里的传入的任务为 Callable 实例，也就是说 schedule 是有返回值的。
        ScheduledFuture<Integer> futureTask = scheduledExecutor.schedule(
                new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return 1;
                    }
                },
                100,
                TimeUnit.MILLISECONDS
        );

        // 会发生阻塞的，直到任务完成！
        System.out.println(futureTask.get());


        // 当然也可以设置 Runable 任务
        scheduledExecutor.schedule(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("task1");
                    }
                },
                100,
                TimeUnit.MILLISECONDS
        );



        executor.shutdown(); // This will make the executor accept no new threads and finish all existing threads in the queue
        while (!executor.isTerminated()) { // Wait until all threads are finish,and also you can use "executor.awaitTermination();" to wait
        }
        System.out.println("Finished all threads");
    }
}
