package pl.sda.intermediate.bankthreads;

import java.math.BigDecimal;

public class Bank {
    private int money = 1000;
    private int counterOperations;
    public void withdraw(int amountWithdraw){
        money = money - amountWithdraw;
    }
    public void deposit(int amountDeposit){
        money = money + amountDeposit;
        counterOperations++;
    }

}
