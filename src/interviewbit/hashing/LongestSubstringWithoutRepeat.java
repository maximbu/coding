package interviewbit.hashing;

import java.util.HashSet;

/**
 * Given a string,
 * find the length of the longest substring without repeating characters.
 *
 * Example:
 *
 * The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 *
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String A) {
        HashSet<Character> hashSet = new HashSet<>();
        int ans = 0;
        int from = 0;
        for (char c : A.toCharArray()) {
            while (!hashSet.add(c)) {
                hashSet.remove(A.charAt(from++));
            }
            ans = Math.max(ans, hashSet.size());
        }

        return ans;
    }

    public static void main(String[] st) {
        LongestSubstringWithoutRepeat q = new LongestSubstringWithoutRepeat();
        System.out.println(q.lengthOfLongestSubstring("a"));
        System.out.println(q.lengthOfLongestSubstring("abcabc"));
        System.out.println(q.lengthOfLongestSubstring("bbb"));
        System.out.println(q.lengthOfLongestSubstring("bbba"));
        System.out.println(q.lengthOfLongestSubstring("dadbc"));
        System.out.println(q.lengthOfLongestSubstring("baacb"));
    }
}
