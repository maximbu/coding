package hackerRank.interviewPrep.DictsAndMaps;

public class SherlokAndAnarams {
    static int sherlockAndAnagrams(String s) {
        int ans = 0;
        for(int size=1;size<s.length();size++){
            ans+=findAnagramsOfSize(size,s);
        }
        return ans;
    }

    static int findAnagramsOfSize(int size , String s) {
        int ans = 0;
        for(int i=0;i<s.length()-size;i++){
            String search = s.substring(i,i+size);
            for(int j=i+1;j<=s.length()-size;j++){
                String comp = s.substring(j, j+size);
                if(anagrams(search,comp)){
                    ans++;
                }
            }
        }
        return ans;
    }

    static boolean anagrams(String s1 , String s2) {
        int[] letters = new int['z'-'a'+1];
        for(char c:s1.toCharArray()){
            letters[c-'a']++;
        }
        for (char c : s2.toCharArray()) {
            letters[c - 'a']--;
        }
        for(int x:letters){
            if(x!=0) return false;
        }
        return true;
    }

    public static void main(String[] st){
        sherlockAndAnagrams("abba");
    }
}
