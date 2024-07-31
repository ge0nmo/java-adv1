package thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV4 implements BankAccount
{
    private int balance;
    private final Lock lock = new ReentrantLock();

    public BankAccountV4(int initialBalance)
    {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount)
    {
        log("거래 시작: " + getClass().getSimpleName());

        lock.lock(); // ReentrantLock 이용하여 lock 걸기

        try{
            // ===임계 영역 시작===
            log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
            if(balance < amount){
                log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
                return false;
            }

            // 잔고가 출금액보다 많으면, 진행
            log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
            sleep(1000);
            balance = balance - amount;
            log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
            // ===임계 영역 종료===
        } finally {
            lock.unlock();    //ReentrantLock 이용하여 lock 해제
        }


        log("거래 종료");
        return true;
    }

    @Override
    public int getBalance()
    {
        lock.lock(); // ReentrantLock 이용하여 lock 걸기
        try{
            return balance;
        } finally {
            lock.unlock(); //ReentrantLock 이용하여 lock 해제
        }

    }
}
