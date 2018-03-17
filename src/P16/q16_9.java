package P16;

/**
 * Created by max on 1/22/2017.
 */
public class q16_9 {
    public int minus(int a,int b){
        return a+neg(b);
    }

    public int neg(int a){
        return (~a)+1;
    }

    public int abs(int a){
        return a<0?neg(a):a;
    }

    public int negIfNeeded(int ans , int a,int b){
        if((a<0) ^ (b < 0)){
            ans = neg(ans);
        }
        return ans;
    }

    public int multiply(int a , int b){
        int smaller = Math.min(abs(a),abs(b));
        int bigger = Math.max(abs(a),abs(b));

        int mul = 0;
        while(smaller>0){
            mul+=bigger;
            smaller = minus(smaller,1);
        }

        return negIfNeeded(mul,a,b);
    }

    public int div(int a , int b) {
        if (b == 0) throw new ArithmeticException();
        int a1 = abs(a);
        int b1 = abs(b);
        int prod = 0;
        int x = 0;
        while (prod + b1 <= a1){
            prod+=b1;
            x++;
        }

        return negIfNeeded(x,a,b);
    }

    public static void main(String[] s){
        q16_9 q = new q16_9();
        System.out.println(q.div(17,5));
        System.out.println(q.div(-17,5));
        System.out.println(q.div(-17,-5));
        System.out.println(q.div(17,-5));
        System.out.println(q.div(100,10));
    }

}
