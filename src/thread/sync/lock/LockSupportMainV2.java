package thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class LockSupportMainV2
{
    public static void main(String[] args)
    {
        ParkTest parkTest = new ParkTest();
        Thread thread1 = new Thread(parkTest, "Thread-1");
        thread1.start();

        // 잠시 대기하여 Thread-1이 park 상태에 빠질 시간을 준다.
        sleep(1000);
        log("Thread-1 state " + thread1.getState());
    }

    static class ParkTest implements Runnable
    {
        @Override
        public void run()
        {
            log("park start");
            LockSupport.parkNanos(2000_000000); // 2초
            log("park end, state " + Thread.currentThread().getState());
            log("interrupt state " + Thread.currentThread().isInterrupted());
        }
    }
}
