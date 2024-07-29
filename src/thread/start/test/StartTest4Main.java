package thread.start.test;

import static java.lang.Thread.sleep;
import static util.MyLogger.log;

public class StartTest4Main
{
    public static void main(String[] args)
    {
        PrintWork a = new PrintWork("A", 1000);
        Thread thread1 = new Thread(a);
        thread1.setName("Thread-A");

        PrintWork b = new PrintWork("B", 500);
        Thread thread2 = new Thread(b);
        thread2.setName("Thread-B");

        thread1.start();
        thread2.start();
    }

    static class PrintWork implements Runnable
    {
        private final String name;
        private final int time;

        public PrintWork(String name, int time)
        {
            this.name = name;
            this.time = time;
        }

        @Override
        public void run()
        {
            while(true){
                try {
                    log("value : " + name);
                    sleep(time);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
