package thread.start;

public class HelloThreadMain
{
    public static void main(String [] args)
    {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        // main thread does not start new Thread but tells HelloThread to start new Thread
        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": start() before call");
        helloThread.start();
        System.out.println(Thread.currentThread().getName() + ": start() after call");

        System.out.println(Thread.currentThread().getName() + ": main() end");

        /*
        main: main() start
        main: start() before call
        main: start() after call
        main: main() end
        Thread-0 is running
        */


    }
}
