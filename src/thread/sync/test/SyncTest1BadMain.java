package thread.sync.test;

public class SyncTest1BadMain
{
    public static void main(String[] args) throws InterruptedException
    {
        Counter counter = new Counter();

        Runnable task = new Runnable()
        {
            @Override
            public void run()
            {
                for(int i = 0; i < 10000; i++){
                    counter.increment();
                }
            }
        };

        Thread t1 = new Thread(task); // called 10,000 times
        Thread t2 = new Thread(task); // called 10,000 times

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("result: " + counter.getCount());
    }

    static class Counter
    {
        private int count = 0;

        public synchronized void increment()
        {
            count = count + 1;
        }

        public synchronized int getCount()
        {
            return count;
        }
    }
}
