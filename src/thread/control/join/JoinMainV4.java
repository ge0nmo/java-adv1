package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV4
{
    public static void main(String[] args) throws InterruptedException
    {
        log("Start");
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);
        Thread thread1 = new Thread(task1, "thread-1");

        thread1.start();

        // 스레드가 종료될 때 까지 대기
        log("join(1000) - main thread is waiting for thread1 for 1 second");
        thread1.join();
        log("min thread completed waiting");

        int sumAll = task1.result + task2.result;
        log("task1 + task2 = " + sumAll);
        log("End");
    }

    static class SumTask implements Runnable
    {
        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue)
        {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run()
        {
            log("작업 시작");
            sleep(2000);
            int sum = 0;
            for(int i = startValue; i <= endValue; i++) {
                sum += i;
            }

            result = sum;
            log("작업 완료 result = " + result);
        }
    }
}
