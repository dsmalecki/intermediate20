package pl.sda.intermediate.threads;

import org.junit.jupiter.api.Test;

public class ThreadsExample {
    @Test
    public void testThreads() {
        Thread thread = new Thread();// pracownik - tak tworzymy wątki
        System.out.println("EAGER"); //praca wykonywana od razu

        Runnable lambdaRunnable = () ->
                System.out.println(Thread.currentThread().getName() + // informacja w ktorym watku pracujemy
                        " LAZY from lambda");// praca do wykonania - instrukcja

        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+
                        " LAZY from anonymous class");
            }
        };

        Runnable regularClassRunnable = new MyRunnable();

        regularClassRunnable.run(); //to uruchomi się w main
        lambdaRunnable.run();
        anonymousRunnable.run();

        Thread thread1 = new Thread(lambdaRunnable);
        Thread thread2 = new Thread(anonymousRunnable);
        Thread thread3 = new Thread(regularClassRunnable);
        System.out.println("------------------------ threads run below");

        thread1.run(); //to też uruchomi się w main - bo użyliśmy run()
        thread2.run();
        thread3.run();

        System.out.println("------------------------ threads second approach below with start method");

        thread1.start(); //to też uruchomi się w main - bo użyliśmy run()
        thread2.start();
        thread3.start();


    }
}
