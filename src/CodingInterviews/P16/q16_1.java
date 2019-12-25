package CodingInterviews.P16;

/**
 * Created by max on 1/21/2017.
 */
public class q16_1 {
    static class Wrapp<T> {
        T num;

        public Wrapp(T num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return num.toString();
        }
    }

    public static void swap(Wrapp<Integer> x, Wrapp<Integer> y) {
        x.num = x.num ^ y.num;
        y.num = x.num ^ y.num;
        x.num = x.num ^ y.num;
    }


    public static void main(String[] st) {
        Wrapp<Integer> x = new Wrapp<Integer>(13);
        Wrapp<Integer> y = new Wrapp<Integer>(23);

        System.out.println("X is :" + x + " Y is :" + y);
        swap(x, y);
        System.out.println("X is :" + x + " Y is :" + y);
    }
}
