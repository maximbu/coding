package CodingInterviews2018.P15;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class q15_3 {
    private static class Chopstick {
        private Lock lock = new ReentrantLock();
        boolean wasLocked = false;

        public boolean pickUp() {
            wasLocked = lock.tryLock();
            return wasLocked;
        }

        public void putDown() {
            if (wasLocked) {
                wasLocked = false;
                lock.unlock();
            }
        }
    }

    private static class Philosopher extends Thread {
        private int bites = 10;
        private Chopstick left, right;

        public Philosopher(Chopstick left, Chopstick right) {
            this.left = left;
            this.right = right;
        }

        public void eat() {
            if (pickUp()) {
                chew();
                putDown();
            }
        }

        private void putDown() {
            right.putDown();
            left.putDown();
        }

        private void chew() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private boolean pickUp() {
            if (left.pickUp()) {
                if (right.pickUp()) {
                    return true;
                } else {
                    left.putDown();
                }
            }
            return false;
        }

        @Override
        public void run() {
            IntStream.range(0, bites).forEach(i -> eat());
        }
    }


    public static void main(String[] st) {
        int n = 8;
        var ch = IntStream.range(0, n).mapToObj(i -> new Chopstick()).toArray(Chopstick[]::new);
        var ph = IntStream.range(0, n).mapToObj(i -> new Philosopher(ch[i], ch[(i + 1) % n])).toArray(Philosopher[]::new);

        for (var p : ph) {
            p.start();
        }
    }
}
