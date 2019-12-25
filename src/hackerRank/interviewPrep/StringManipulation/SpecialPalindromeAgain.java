package hackerRank.interviewPrep.StringManipulation;

import java.util.ArrayList;

public class SpecialPalindromeAgain {

    static class Node {
        int count;
        char c;

        Node(char c, int cnt) {
            this.c = c;
            this.count = cnt;
        }
    }

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        ArrayList<Node> arr = createOccArr(s);
        return countSame(arr);
    }

    static ArrayList<Node> createOccArr(String s) {
        ArrayList<Node> arr = new ArrayList<>();
        int cnt = 0;
        char prev = s.charAt(0);
        for (char c : s.toCharArray()) {
            if (c == prev) {
                cnt++;
            } else {
                arr.add(new Node(prev, cnt));
                prev = c;
                cnt = 1;
            }
        }
        arr.add(new Node(prev, cnt));
        return arr;
    }

    static long countSame(ArrayList<Node> arr) {
        long ans = 0;
        for (int i = 0; i < arr.size(); i++) {
            // aaaa -> a=4 + aa=3 + aaa=2 + aaaa=1 => n*(1+n)/2
            ans += ((1 + arr.get(i).count) * arr.get(i).count) / 2;
            ans += checkSpecialCase(arr, i);
        }
        return ans;
    }

    static long checkSpecialCase(ArrayList<Node> arr, int i) {
        if (arr.get(i).count != 1 || i == 0 || i == arr.size() - 1) {
            return 0;
        }
        Node pre = arr.get(i - 1);
        Node next = arr.get(i + 1);
        return pre.c == next.c ? Math.min(pre.count, next.count) : 0;
    }

    public static void main(String[] st) {
        substrCount(5, "asasd");
    }
}
