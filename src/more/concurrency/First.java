package more.concurrency;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dmitry Titorenko on 08.03.2018
 */
public class First implements Runnable {
    private static int i = 0;
    Runnable runnable = () -> {
        System.out.println("run");
    };

    public static void main(String[] args) {
        Lock myLock = new ReentrantLock();
        Condition condition = myLock.newCondition();

        First first = new First();

        Thread thread = new Thread(first);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println(thread.getUncaughtExceptionHandler());
        thread.run();


        // this code equals someSync()

        myLock.lock();
        try {
            while (i < 10) {
                condition.await();
            }
            int tempI = i;
            tempI += 2;
            tempI -= 10;
            i = tempI;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("1 " + thread.isInterrupted());
        System.out.println("1.1 " + Thread.currentThread().isInterrupted());
        thread.interrupt();
        Thread.currentThread().interrupt();

        System.out.println("2 " + thread.isInterrupted());
        System.out.println("2.1 " + Thread.currentThread().isInterrupted());

        Thread.interrupted();
        System.out.println(thread.isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());

        some();


    }

    public synchronized void someSync() {
        try {
            while (i < 10) {
                wait();
            }
            int tempI = i;
            tempI += 2;
            tempI -= 10;
            i = tempI;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Run");
    }

    public static int some() {
        return 3;
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("run extends");
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {

    }
}