package thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class LockSupportMainV1
{
    public static void main(String[] args)
    {
        ParkTest parkTest = new ParkTest();
        Thread thread1 = new Thread(parkTest, "Thread-1");
        thread1.start();

        // 잠시 대기하여 Thread-1이 park 상태에 빠질 시간을 준다.
        sleep(1000);
        log("Thread-1 state " + thread1.getState());

        log("main -> unpark(Thread-1)");
        LockSupport.unpark(thread1); // 1. unpark() 사용
        //thread1.interrupt(); // 2. interrupt() 사용


    }

    static class ParkTest implements Runnable
    {

        @Override
        public void run()
        {
            log("park start");
            LockSupport.park(); // 이 코드를 호출한 스레드는 Runnable -> Waiting 상태로 변화
            log("park end, state " + Thread.currentThread().getState());
            log("interrupt state " + Thread.currentThread().isInterrupted());
        }
    }
}
