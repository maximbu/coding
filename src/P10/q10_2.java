package P10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by max on 12/29/2016.
 */
public class q10_2 {
    public static String[] sortAnagrams(String[] a){
        if(a.length < 2){
            return a;
        }

        HashMap<String,LinkedList<String>> hash = new HashMap<>();
        for(String s:a){
            char[] tmp1 = s.toCharArray();
            Arrays.sort(tmp1);
            String tmp = new String(tmp1);
            if(!hash.containsKey(tmp)){
                hash.put(tmp,new LinkedList<>());
            }
            LinkedList<String> list = hash.get(tmp);
            list.add(s);
        }
        String[] ans = new String[a.length];
        int i = 0;
        for(LinkedList<String> an: hash.values()){
            for(String s:an){
                ans[i++]=s;
            }
        }
        return ans;
    }

    public static void main(String[] st){
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        String[] array2 = sortAnagrams(array);
    }
}
