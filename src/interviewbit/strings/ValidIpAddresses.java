package interviewbit.strings;

import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.
 *
 * Example:
 *
 * Given “25525511135”,
 *
 * return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)
 */
public class ValidIpAddresses {

    public ArrayList<String> restoreIpAddresses(String A) {
        ArrayList<String> ans = new ArrayList<>();
        restoreIpAddresses(A, ans, 1, new ArrayList<>());
        ans.sort(String::compareTo);
        return ans;
    }

    private void restoreIpAddresses(String A, ArrayList<String> ans, int ind, ArrayList<String> soFar) {
        if (ind == 5) {
            if (A.isEmpty()) {
                ans.add(String.join(".", soFar));
            }
            return;
        }
        for (int i = 1; i <= Math.min(3, A.length()); i++) {
            String num = A.substring(0, i);
            int x = Integer.parseInt(num);
            if ((num.equals("0") || (x < 256 && (A.charAt(0) != '0')))
                    && A.length() <= (5 - ind) * 3) {
                soFar.add(num);
                restoreIpAddresses(A.substring(i), ans, ind + 1, soFar);
                soFar.remove(soFar.size() - 1);
            }
        }
    }

    public static void main(String[] st) {
        ValidIpAddresses q = new ValidIpAddresses();
        System.out.println(q.restoreIpAddresses("25525511135"));
    }

}
