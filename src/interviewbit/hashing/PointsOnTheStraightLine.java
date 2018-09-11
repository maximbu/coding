package interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class PointsOnTheStraightLine {

    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        int maxPoints = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        if(a.size()< 2)
            return a.size();
        for(int i = 0; i < a.size(); i++) {
            int dup = 1;
            for (int j = i + 1; j < a.size(); j++) {
                Double slope = calcSlope(a.get(i), b.get(i), a.get(j), b.get(j));
                if(slope == null){
                    dup++;
                }
                else {
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                }
            }

            maxPoints = Math.max(maxPoints, dup + map.values().stream().max(Integer::compareTo).orElse(0));

            map.clear();
        }

        return maxPoints;
    }

    private Double calcSlope(int x0, int y0 , int x1 , int y1){
        if(x0 == x1 && y0 == y1) return null; //dup
        if ( x1 - x0 == 0) return Double.MAX_VALUE;
        double ans =  (double)(y1-y0)/(double)(x1-x0);
        return ans == -0.0 ? 0.0 : ans;
    }

    public static void main(String[] st) {
        PointsOnTheStraightLine q = new PointsOnTheStraightLine();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(1);
        A.add(1);
        A.add(1);
        A.add(1);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(1);
        B.add(1);
        B.add(1);
        B.add(1);
        B.add(1);
        System.out.println(q.maxPoints(A, B));
        A.clear();
        A.add(4);
        A.add(8);
        A.add(-4);
        B.clear();
        B.add(-4);
        B.add(-4);
        B.add(-4);
        System.out.println(q.maxPoints(A, B));
    }
}
