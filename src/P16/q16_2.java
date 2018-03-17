package P16;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by max on 1/21/2017.
 */
public class q16_2 {
    public class Freq {
        HashMap<String,Integer> map;
        public Freq(String[] book){
            map = new HashMap<String,Integer>();
            for (String st: book) {
                String s = st.toLowerCase();
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }

        public int getFreq(String st){
            if(st == null) return -1;
            return map.getOrDefault(st.toLowerCase(),0);
        }
    }
}
