package thread.start.test;

import static util.MyLogger.log;

public class StartTest1Main
{
    public static void main(String[] args)
    {
        CounterThread counterThread = new CounterThread();
        counterThread.setName("counter");
        counterThread.start();
    }

    static class CounterThread extends Thread
    {
        @Override
        public void run()
        {
            for(int i = 1; i <= 5; i++){
                try {
                    log("value: " + i);
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

