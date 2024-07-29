package thread.start;

public class BadThreadMain
{
    public static void main(String [] args)
    {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        // main thread runs HelloThread method
        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": start() before call");
        helloThread.run(); // run() 직접 실행
        System.out.println(Thread.currentThread().getName() + ": start() after call");

        System.out.println(Thread.currentThread().getName() + ": main() end");

        /*
        main: main() start
        main: start() before call
        main is running
        main: start() after call
        main: main() end
        */


    }
}
