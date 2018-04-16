package CodingInterviews.P1;

/**
 * Created by max on 12/16/2016.
 */
public class q1_5 {
    public static boolean oneAway(String st1,String st2) {
        if(st1.length() == st2.length())
            return oneEditAway(st1,st2);
        if(st1.length() == st2.length()+1)
            return oneInsertAway(st1,st2);
        if(st1.length()+1 == st2.length())
            return oneInsertAway(st2,st1);
        return false;
    }

    private static boolean oneInsertAway(String st1, String st2) {
        int shifted = 0;
        for(int i=0;i<st2.length();i++){
            if(st1.charAt(i+shifted) != st2.charAt(i))
            {
               if(shifted == 1)
                   return false;
               shifted = 1;
               i--;
            }
        }
        return true;
    }

    private static boolean oneEditAway(String st1, String st2) {
        boolean foundDiff = false;
        for(int i=0;i<st1.length();i++){
            if(st1.charAt(i) != st2.charAt(i))
            {
                if(foundDiff) return false;
                foundDiff = true;
            }
        }
        return foundDiff;
    }



    public static void main(String[] args) {
        System.out.println("oneAway(pale,ple)"+"->"+oneAway("pale","ple"));
        System.out.println("oneAway(pales,pale)"+"->"+oneAway("pales","pale"));
        System.out.println("oneAway(pale,bale)"+"->"+oneAway("pale","bale"));
        System.out.println("oneAway(pale,bake)"+"->"+oneAway("pale","bake"));
    }
}
