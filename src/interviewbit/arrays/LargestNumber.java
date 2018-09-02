package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by max on 7/1/2017.
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example:

 Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
  // DO NOT MODIFY THE LIST
  public String largestNumber(final List<Integer> a) {
    List<String> a2 = a.stream().map(Object::toString)
        .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2)).collect(Collectors.toList());
    StringBuilder b = new StringBuilder();
    for (String anA : a2) {
      if(!anA.equals("0")) {
        b.append(anA);
      }
    }
    if(b.length() == 0) return "0";
    return b.toString();
  }

  public static void main(String[] st){
    LargestNumber q = new LargestNumber();

    ArrayList<Integer> X = new ArrayList<>();
    X.add(3);
    X.add(30);
    X.add(34);
    X.add(5);
    X.add(9);

    System.out.println(q.largestNumber(X));

    // 99197494093090589587787286882579979879178278077273570968668667867566465335024704093953663633573372929827126124019124113
    // 99197494093090589587787286882579979879178278077273570968668667867566465335024704093953663633573372982927126124019124113
  }
}
