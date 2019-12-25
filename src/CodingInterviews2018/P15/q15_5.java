package CodingInterviews2018.P15;

import java.util.concurrent.Semaphore;

public class q15_5 {
    private static class Foo {
        private Semaphore s1, s2;

        public Foo() {
            s1 = new Semaphore(1);
            s2 = new Semaphore(1);

            try {
                s1.acquire();
                s2.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        public void first() {
            try {
                System.out.println("First");
            } finally {
                s1.release();
            }
        }

        public void second() {
            try {
                s1.acquire();
                s1.release();
                System.out.println("Second");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s2.release();
            }
        }


        public void third() {
            try {
                s2.acquire();
                s2.release();
                System.out.println("Third");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
