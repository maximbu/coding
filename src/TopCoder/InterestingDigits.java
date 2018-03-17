package TopCoder;

import java.util.*;

public class InterestingDigits {
    public int[] digits(int base){
        List<Integer> ans = new ArrayList<>();
        for(int i=2;i<base;i++){
            if(isInterestingDigit(i,base)){
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(i->i).toArray();
    }

    private boolean isInterestingDigit(int d,int base){
        int maxNum = base*base*base*base;
        for(int i=d;i<maxNum;i+=d){
            if(digitSum(i,base)%d != 0){
                return false;
            }
        }
        return true;
    }

    private int digitSum(int d,int base){
        int ans = 0;
        while(d>0){
            ans += d % base;
            d/=base;
        }
        return ans;
    }


    public static  void main(String[] st){
        InterestingDigits s = new InterestingDigits();
        System.out.println(Arrays.toString(s.digits(9)));
    }
}