package pl.sda.intermediate.bankthreads;

import java.util.Random;

public class ClientAction implements Runnable {

    @Override
    public void run() {
        int amount = new Random().nextInt(50) + 1;
        Bank.withdraw(amount);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Bank.deposit(amount);
    }
}
