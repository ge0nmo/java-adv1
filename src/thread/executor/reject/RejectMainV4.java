package thread.executor.reject;

import thread.executor.RunnableTask;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;

public class RejectMainV4
{
    public static void main(String[] args)
    {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0,
                TimeUnit.SECONDS, new SynchronousQueue<>(), new MyRejectedExecutionHandler());

        executor.submit(new RunnableTask("task1")); // 0초
        executor.submit(new RunnableTask("task2")); // 1초
        executor.submit(new RunnableTask("task3")); // 0초 -> 1초
        //executor.submit(new RunnableTask("task4")); // 0초

        executor.close();


    }

    static class MyRejectedExecutionHandler implements RejectedExecutionHandler
    {
        static AtomicInteger count = new AtomicInteger(0);
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor)
        {
            int i = count.incrementAndGet();
            log("[결고] 거절 된 누적 작업 수: " + i);
        }
    }
}
