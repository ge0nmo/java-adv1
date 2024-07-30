package thread.control.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;

public class MyPrinterV4
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
        }
    }

    static class Printer implements Runnable
    {
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run()
        {
            while(!Thread.interrupted()){
                if(jobQueue.isEmpty()){
                    Thread.yield();
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
