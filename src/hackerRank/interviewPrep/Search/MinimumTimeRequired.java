package hackerRank.interviewPrep.Search;

import java.util.Arrays;

public class MinimumTimeRequired {
    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        long from = (goal*machines[0])/machines.length;
        long to = (goal*machines[machines.length-1])/machines.length;
        return findMin(machines,from,to,goal);
    }

    static long findMin(long[] machines, long from,long to,long goal) {
        long mid = (from+to)/2;
        if(!canCreate(machines,mid,goal)){
            return findMin(machines, mid+1, to, goal);
        }
        if(!canCreate(machines,mid-1,goal)){
            return mid;
        }
        return findMin(machines, from, mid-1, goal);
    }

    static boolean canCreate(long[] machines, long days,long goal) {
        long cnt = Arrays.stream(machines).map(machine -> days / machine).sum();
        return cnt>=goal;
    }

    public static void main(String[] st) {
        System.out.println(minTime( new long[]{1,3,4},10));
        System.out.println(minTime( new long[]{2,3},5));
    }
}
