package CodingInterviews2018.P15;

import java.util.function.Function;
import java.util.function.Predicate;

public class q15_6 {
    private static class FBThread extends Thread{
        private static final Object lock = new Object();
        protected static int curr = 1;
        private int max;

        public FBThread(int max, Predicate<Integer> validate, Function<Integer, String> printer) {
            this.max = max;
            this.validate = validate;
            this.printer = printer;
        }

        public void run(){
            while (true){
                synchronized (lock){
                    if(curr > max){
                        return;
                    }
                    if(validate.test(curr)){
                        System.out.println(printer.apply(curr));
                        curr++;
                    }
                }
            }
        }

        private Predicate<Integer> validate;
        private Function<Integer,String> printer;



    }

    private static void fizzBuzz(int n) {
        Thread[] th = {
                new FBThread(n, i -> i % 3 == 0 && i % 5 == 0, i -> "FizzBuzz"),
                new FBThread(n, i -> i % 3 == 0 && i % 5 != 0, i -> "Fizz"),
                new FBThread(n, i -> i % 3 != 0 && i % 5 == 0, i -> "Buzz"),
                new FBThread(n, i -> i % 3 != 0 && i % 5 != 0, i -> "" + i)
        };
        for (var t : th) {
            t.start();
        }
    }

    public static void main(String[] st){
        fizzBuzz(100);
    }
}
