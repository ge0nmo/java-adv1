package thread.control.test;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinTest1Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread t1 = new Thread(new MyTask(), "t1");
        Thread t2 = new Thread(new MyTask(), "t2");
        Thread t3 = new Thread(new MyTask(), "t3");

        t1.start(); // 3s
        t1.join(); // wait

        t2.start(); // 3s
        t2.join(); // wait

        t3.start(); // 3s
        t3.join(); // wait
        System.out.println("모든 스레드 실행 완료");
    }

    static class MyTask implements Runnable
    {

        @Override
        public void run()
        {
            for(int i = 1; i <= 3; i++){
                log(i);
                sleep(1000);
            }
        }
    }
}
