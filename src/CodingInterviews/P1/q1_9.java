package CodingInterviews.P1;

/**
 * Created by max on 12/16/2016.
 */
public class q1_9 {

    public static boolean stringRotation(String st1, String st2) {
        return st1.length() == st2.length() && (st1 + st1).contains(st2);
    }


    public static void main(String[] args) {
        System.out.println("stringRotation(waterbottle,erbottlewat)" + "->" + stringRotation("waterbottle", "erbottlewat"));
        System.out.println("stringRotation(waterbottle,erbottlewate)" + "->" + stringRotation("waterbottle", "erbottlewate"));
        System.out.println("stringRotation(waterbottle,erbottlewar)" + "->" + stringRotation("waterbottle", "erbottlewar"));

    }
}
