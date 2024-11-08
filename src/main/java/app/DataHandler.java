package app;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataHandler {
    private final Lock lock = new ReentrantLock();

    public int modify(int num) {
        try {
            while (!lock.tryLock()) {
                System.out.println("Waiting for lock");
            }
            num = num * 3;
        } finally {
            lock.unlock();
        }
        return num;
    }
}
