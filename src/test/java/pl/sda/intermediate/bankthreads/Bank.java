package pl.sda.intermediate.bankthreads;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

public class Bank {
    private static AtomicInteger money = new AtomicInteger(1000);
    private static AtomicInteger counterOperations = new AtomicInteger(0);

    public /*synchronized*/ static void withdraw(int amountWithdraw) {
        money.addAndGet(-amountWithdraw);    }

    public /*synchronized*/ static void deposit(int amountDeposit) {
        money.addAndGet(amountDeposit);
        counterOperations.incrementAndGet();
    }

    public static int getMoney() {
        return money.get();
    }

    public static int getCounterOperations() {
        return counterOperations.get();
    }
}
