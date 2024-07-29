package thread.start.test;

import static java.lang.Thread.sleep;
import static util.MyLogger.log;

public class StartTest3Main
{
    public static void main(String[] args)
    {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 5; i++) {
                        log("value: " + i);
                        sleep(1000);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable, "counter");
        thread.start();
    }
}
