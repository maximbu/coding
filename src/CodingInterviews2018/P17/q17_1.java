package CodingInterviews2018.P17;

public class q17_1 {

    private static int add(int a, int b) {
        while (b != 0) {
            int sum = a ^ b; //1+1=0
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 12;
        int b = 18;
        System.out.printf("%d+%d=%d%n", a, b, add(a, b));

        a = 14;
        b = 15;
        System.out.printf("%d+%d=%d%n", a, b, add(a, b));
    }
}
