package CodingInterviews2018.P16;

public class q16_1 {

    private static void swap(IntWrapper a, IntWrapper b) {
        a.x = a.x^b.x; //a diff b
        b.x = a.x^b.x;  //a
        a.x = a.x^b.x;  //b
    }

    public static void main(String[] args) {
        IntWrapper a = new IntWrapper(123);
        IntWrapper b = new IntWrapper(456);
        System.out.println("before swap" + " a is " + a + " ,b is " + b);
        swap(a, b);
        System.out.println("after swap" + " a is " + a + " ,b is " + b);

    }
}
