package thread.control.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain
{
    public static void main(String[] args)
    {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        thread.start();

        sleep(1000);
        log("runFlag to false");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main finish");
    }

    static class MyTask implements Runnable
    {
        //boolean runFlag = true;
        volatile boolean runFlag = true;

        @Override
        public void run()
        {
            log("Task start");
            while(runFlag){
                // runFlag = false -> break;
            }

            log("task finish");
        }
    }
}
