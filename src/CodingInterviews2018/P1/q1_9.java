package CodingInterviews2018.P1;

public class q1_9 {
  private static boolean isStringRotation(String st1 , String st2){
    return (st1.length() == st2.length()) && (st1+st1).contains(st2)	;
  }

  public static void main(String[] args) {
    System.out.println("isStringRotation(waterbottle,erbottlewat)"+"->"+isStringRotation("waterbottle","erbottlewat"));
    System.out.println("isStringRotation(waterbottle,erbottlewate)"+"->"+isStringRotation("waterbottle","erbottlewate"));
    System.out.println("isStringRotation(waterbottle,erbottlewar)"+"->"+isStringRotation("waterbottle","erbottlewar"));

  }
}
