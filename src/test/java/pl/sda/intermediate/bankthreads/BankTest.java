package pl.sda.intermediate.bankthreads;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BankTest {
    @RepeatedTest(20)
    public void bankTest() {
        Runnable clientAction = new ClientAction(); //praca do wykonania przez każdego klienta
        List<Thread> threadsList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(clientAction); // tutaj tworzymy klientow i przekazujemy im instrukcje
            threadsList.add(thread);
        }
        for (Thread thread : threadsList) {
            thread.start();
        }
        for (Thread thread : threadsList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Bank.getMoney());
        System.out.println(Bank.getCounterOperations());
    }
}
