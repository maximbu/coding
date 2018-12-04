package hackerRank.interviewPrep.DictsAndMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencyQueries {
    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> numToFreq = new HashMap<>();
        HashMap<Integer, Integer> freqToNums = new HashMap<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                updateFreqForNumber(numToFreq, freqToNums, q[1], 1);
            }
            if (q[0] == 2) {
                if(numToFreq.getOrDefault(q[1],0)>0) {
                    updateFreqForNumber(numToFreq, freqToNums, q[1], -1);
                }
            }
            if (q[0] == 3) {
                ans.add(freqToNums.containsKey(q[1])? 1 : 0);
            }
        }
        return ans;
    }

    static void updateFreqForNumber(HashMap<Integer,Integer> numToFreq,HashMap<Integer,Integer> freqToNums, Integer number , int change ) {
        int origFreq = numToFreq.getOrDefault(number, 0);
        int numsForOrigFreq = freqToNums.getOrDefault(origFreq,0);
        if (numsForOrigFreq == 1) {
            freqToNums.remove(origFreq);
        }
        if (numsForOrigFreq > 1) {
            freqToNums.put(origFreq,numsForOrigFreq-1);
        }
        int newFreq = origFreq + change;
        numToFreq.put(number, newFreq);
        freqToNums.put(newFreq, freqToNums.getOrDefault(newFreq,0)+1);
    }
}
