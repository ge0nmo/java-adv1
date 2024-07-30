package thread.control.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class MyPrinterV2
{
    public static void main(String[] args)
    {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner userInput = new Scanner(System.in);
        while(true){
            log("input a word. quit (q): ");
            String input = userInput.nextLine();
            if(input.equals("q")){
                printerThread.interrupt();
                break;
            }
            printer.addJob(input);
            continue;
        }
    }

    static class Printer implements Runnable
    {
        volatile boolean work = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run()
        {
            while(work){
                if(jobQueue.isEmpty()){
                    continue;
                }

                try {
                    String job = jobQueue.poll();
                    log("print: " + job + " waiting: " + jobQueue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    log("interrupt!");
                    break;
                }
                log("completed to print");
            }
            log("printer finished");
        }

        public void addJob(String input){
            jobQueue.offer(input);
        }
    }


}
