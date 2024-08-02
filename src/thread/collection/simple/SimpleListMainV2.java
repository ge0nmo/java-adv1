package thread.collection.simple;

import static util.MyLogger.log;

public class SimpleListMainV2
{
    public static void main(String[] args) throws InterruptedException
    {
        //test(new BasicList());
        //test(new SyncList());
        test(new SyncProxyList(new BasicList()));
    }

    private static void test(SimpleList list) throws InterruptedException
    {
        log(list.getClass().getSimpleName());
        Runnable addA = new Runnable()
        {
            @Override
            public void run()
            {
                list.add("A");
                log("Thread-1: list.add(A)");
            }
        };

        Runnable addB = new Runnable()
        {
            @Override
            public void run()
            {
                list.add("B");
                log("Thread-2: list.add(B)");
            }
        };
        Thread t1 = new Thread(addA);
        Thread t2 = new Thread(addB);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        log(list);
    }
}
