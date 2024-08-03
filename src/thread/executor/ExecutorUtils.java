package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static util.MyLogger.log;

public abstract class ExecutorUtils
{
    public static void printState(ExecutorService executorService)
    {
        if(executorService instanceof ThreadPoolExecutor poolExecutor){
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount();
            int queued = poolExecutor.getQueue().size(); // 작업이 몇개 들어가 있나?
            long completedTask = poolExecutor.getCompletedTaskCount();
            log("[pool=" + pool + ", active=" + active + ", queued=" + queued + ", completedTaskCount=" + completedTask + "]");
        } else{
            log(executorService);
        }
    }
}
