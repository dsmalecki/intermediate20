package pl.sda.intermediate.threads;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Lazy from regular class");
    }
}
