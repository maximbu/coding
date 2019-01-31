package hackerRank.interviewPrep.Graphs;

import java.util.LinkedList;

public class RoadsAndLibraries {
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if (c_lib <= c_road) {
            return (long) n * c_lib;
        }
        long ans = 0;
        boolean[][] connMap = new boolean[n + 1][n + 1];
        for (int[] road : cities) {
            connMap[road[0]][road[1]] = connMap[road[1]][road[0]] = true;
        }
        boolean[] canReachLib = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (!canReachLib[i]) {
                ans += c_lib + c_road * connectRoads(i, connMap, canReachLib);
            }
        }
        return ans;
    }

    private static long connectRoads(int city, boolean[][] connMap, boolean[] canReachLib) {
        LinkedList<Integer> nodes = new LinkedList<>();
        nodes.add(city);
        long roadsNeeded = -1;
        while(!nodes.isEmpty()){
            int origin = nodes.removeFirst();
            if(!canReachLib[origin]) {
                canReachLib[origin] = true;
                roadsNeeded++;
                for (int i = 1; i <= canReachLib.length; i++) {
                    if (connMap[origin][i]) {
                        nodes.addLast(i);
                    }
                }
            }
        }
        return roadsNeeded;
    }

}
